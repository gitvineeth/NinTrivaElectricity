package com.electricity.nintriva.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.electricity.nintriva.constants.AppConstants;
import com.electricity.nintriva.entity.PriceSlabDetails;
import com.electricity.nintriva.entity.RegistrationEntity;
import com.electricity.nintriva.model.BillDetails;
import com.electricity.nintriva.repository.BillRepository;
import com.electricity.nintriva.repository.PriceSlabRepository;
import com.electricity.nintriva.repository.RegistrationRepository;
import com.electricity.nintriva.service.BillService;
import com.electricity.nintriva.shared.Utils;

@Component
public class BillServiceImpl implements BillService {

	@Autowired
	PriceSlabRepository priceSlabRepository;

	@Autowired
	BillRepository billRepository;

	@Autowired
	Utils utils;

	@Autowired
	RegistrationRepository registrationRepository;

	@Override
	public String submitBill(BillDetails billInputDetails) {

		String dateToday = utils.formatDate(LocalDate.now());
		if (!ObjectUtils.isEmpty(retrieveBill(String.valueOf(billInputDetails.getConsumerNumber()), dateToday))) {
			throw new RuntimeException("Bill Already Submitted");
		}
		int billAmount = 0;
		int consumedUnits = 0;
		BillDetails billdetailList = billRepository.findPreviousBill(billInputDetails.getConsumerNumber());
		if (ObjectUtils.isEmpty(billdetailList)) {
			consumedUnits = billInputDetails.getCurrentReading();

		} else {
			consumedUnits = billInputDetails.getCurrentReading()-billdetailList.getCurrentReading();
		}
		billInputDetails.setConsumedUnits(consumedUnits);
		List<Integer> unitList = new ArrayList<Integer>();
		List<PriceSlabDetails> detailList = (List<PriceSlabDetails>) priceSlabRepository.findAll();

		detailList.forEach(item -> unitList.add(item.getUnitSlab()));
		Collections.sort(unitList);

		Optional<PriceSlabDetails> finalPriceSlab = getUnitSlab(unitList, detailList,
				billInputDetails.getConsumedUnits());
		if (finalPriceSlab.isPresent()) {
			billAmount = finalPriceSlab.get().getPerUnitPrice() * billInputDetails.getConsumedUnits();
			billInputDetails.setBillAmount(billAmount);
			billInputDetails.setBillDate(LocalDate.now());
			// billInputDetails.setConsumedUnits(consumedUnits);
			billRepository.save(billInputDetails);
			return AppConstants.BILL_SUBMITTED;

		} else {
			throw new RuntimeException("Something went wrong");
		}

	}

	private Optional<PriceSlabDetails> getUnitSlab(List<Integer> unitList, List<PriceSlabDetails> detailList,
			int consumedUnits) {

		int tempUnits;
		if (unitList.contains(consumedUnits)) {

			tempUnits = consumedUnits;
		} else if (consumedUnits < unitList.get(0)) {
			tempUnits = unitList.get(0);
		} else {
			List<Integer> list = unitList.stream().filter(s -> consumedUnits > s).collect(Collectors.toList());
			Collections.sort(list);
			tempUnits = list.get(list.size() - 1);
		}
		return detailList.stream().filter(i -> i.getUnitSlab() == tempUnits).findFirst();

	}

	public BillDetails generateBill(String consumerNumber, String date) {

		return retrieveBill(consumerNumber, date);
	}

	private RegistrationEntity checkIfConsumerNoExists(int consumerNo) {

		return registrationRepository.findByConsumerNumber(consumerNo);

	}

	private BillDetails retrieveBill(String consumerNumber, String date) {

		if (ObjectUtils.isEmpty(checkIfConsumerNoExists(Integer.parseInt(consumerNumber)))) {
			throw new RuntimeException("invalid user  "+consumerNumber);
		}
		BillDetails billDetails = new BillDetails();
		String[] strArray = date.split("-");
		billDetails = billRepository.findUserBill(Integer.parseInt(consumerNumber), Integer.parseInt(strArray[0]),
				Integer.parseInt(strArray[1]));
		return billDetails;

	}

}
