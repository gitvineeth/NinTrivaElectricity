package com.electricity.nintriva.shared;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789abcdefghijkLMBNSDHJHDY";
	private final int ITERATIONS = 1000;
	private final int KEY_LENGTH = 256;

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(returnValue);
	}

	public String formatDate(LocalDate billDate) {

		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-yyyy-dd");
		return billDate.format(formatters);
	     

	}

}
