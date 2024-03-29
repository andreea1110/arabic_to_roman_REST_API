package com.adobe.interview;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RomanNumeralsController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/arabicToRoman")
	public RomanNumerals convertNumbers(
		@RequestParam(value = "min", defaultValue = "1") int min,
		@RequestParam(value = "max", defaultValue = "10") int max) {
		
		NumberConverter arabicNumbers = new NumberConverter();

		try {
			String[] romanNumerals = arabicNumbers.arabicToRoman(min, max);
			return new RomanNumerals(counter.incrementAndGet(), romanNumerals);
		}
		catch (IllegalArgumentException exp) {
			Logger logger = Logger.getLogger(RomanNumeralsController.class.getName());
			logger.log(Level.SEVERE, "Requested interval exceeds valid range");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interval exceeds valid range", exp);
		}		
	}
}