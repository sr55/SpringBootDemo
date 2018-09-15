package com.sr.string.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.string.services.distance.interfaces.StringDistance;
import com.sr.string.services.distance.model.StringDistanceResult;

@RestController
public class StringDistanceRestService {

	private StringDistance stringDistanceService;

	public StringDistanceRestService(StringDistance stringDistanceService) {
		this.stringDistanceService = stringDistanceService;
	}

	@RequestMapping("/StringDistance")
	public StringDistanceResult getStringDistance(String start, String end) {

		int distance = stringDistanceService.getStringDistance(start, end);
		StringDistanceResult result = new StringDistanceResult(distance); // Spring boot will convert to JSON.

		return result;
	}

	public StringDistance getStringDistanceService() {
		return stringDistanceService;
	}

	public void setStringDistanceService(StringDistance stringDistanceService) {
		this.stringDistanceService = stringDistanceService;
	}
}
