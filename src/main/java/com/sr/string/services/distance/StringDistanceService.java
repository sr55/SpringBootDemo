package com.sr.string.services.distance;

import org.springframework.stereotype.Service;

import com.sr.string.services.distance.interfaces.StringDistance;

@Service
public class StringDistanceService implements StringDistance {

	public int getStringDistance(String start, String end) {

		// Perform some up front edge case handling.
		if (start == null) {
			if (end == null) {
				return 0;
			}

			return end.length();
		}

		if (start.equals(end)) {
			return 0;
		}

		if (end == null) {
			return start.length();
		}

		// Build up a distance cost matrix based on Levenshtein distance algorithm.
		int[][] distanceMatrix = new int[start.length() + 1][end.length() + 1];

		for (int i = 0; i <= start.length(); i++) {
			distanceMatrix[i][0] = i;
		}

		for (int j = 0; j <= end.length(); j++) {
			distanceMatrix[0][j] = j;
		}

		for (int i = 1; i <= start.length(); i++) {
			for (int j = 1; j <= end.length(); j++) {
				int substitutionCost = (end.charAt(j - 1) == start.charAt(i - 1)) ? 0 : 1;

				int delConst = distanceMatrix[i - 1][j] + 1;
				int insertCost = distanceMatrix[i][j - 1] + 1;
				int subCost = distanceMatrix[i - 1][j - 1] + substitutionCost;

				distanceMatrix[i][j] = Math.min(Math.min(delConst, insertCost), subCost);
			}
		}

		return distanceMatrix[start.length()][end.length()];
	}
}
