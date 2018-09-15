package com.sr.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sr.string.services.distance.interfaces.StringDistance;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringDistanceApplicationTests {

	@Autowired
	private StringDistance stringDistanceService;

	@Test
	public void should_returnZero_ForEqualStrings() {
		// Arrange
		String start = "Test";
		String end = "Test";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 0);
	}
	
	@Test
	public void should_returnZero_ForNullStrings() {
		// Arrange
		String start = null;
		String end = null;

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 0);
	}

	@Test
	public void should_returnCorrectResult_ForLonger() {
		// Arrange
		String start = "Kitten";
		String end = "Sitting";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 3);
	}

	@Test
	public void should_returnCorrectResult_ForShorterStrings() {
		// Arrange
		String start = "Edinburgh";
		String end = "Toronto";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 9);
	}

	@Test
	public void should_returnCorrectResult_ForNullStartString() {
		// Arrange
		String start = null;
		String end = "Sitting";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 7);
	}

	@Test
	public void should_returnCorrectResult_ForEmptyStartString() {
		// Arrange
		String start = "";
		String end = "Sitting";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 7);
	}

	@Test
	public void should_returnCorrectResult_ForNullEndString() {
		// Arrange
		String start = "Sitting";
		String end = null;

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 7);
	}

	@Test
	public void should_returnCorrectResult_ForEmptyEndString() {
		// Arrange
		String start = "Sitting";
		String end = "";

		// Act
		int result = stringDistanceService.getStringDistance(start, end);

		// Assert
		assertEquals(result, 7);
	}

	public StringDistance getStringDistanceService() {
		return stringDistanceService;
	}

	public void setStringDistanceService(StringDistance stringDistanceService) {
		this.stringDistanceService = stringDistanceService;
	}
}
