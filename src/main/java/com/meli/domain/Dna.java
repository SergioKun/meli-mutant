package com.meli.domain;


public class Dna {

	private String matrix[][];
	private static final int NUMER_DNA_BY_MUTANT = 2;
	private static final int NUMER_SEQUENCE_LETTERS = 4;

	public Dna(String[] dna) {

		matrix = new String[dna.length][dna[0].length()];

		for (int i = 0; i < matrix.length; i++) {

			String[] lettersDna = dna[i].split("");

			for (int j = 0; j < matrix[i].length; j++) {

				matrix[i][j] = lettersDna[j];
			}
		}
	}

	public boolean IsMutantValidate() {

		String letterBeforeDiagonal = "";
		int countDiagonal = 1;
		int mutantCount = 0;

		for (int x = 0; x < matrix.length; x++) {

			String letterBeforeRow = "";
			String letterBeforeColumn = "";
			int countRow = 1;
			int countColumn = 1;

			if (mutantCount >= NUMER_DNA_BY_MUTANT) {
				return true;
			}

			for (int y = 0; y < matrix[x].length; y++) {

				if (letterBeforeRow.equals(matrix[x][y])) {

					countRow++;

					if (countRow == NUMER_SEQUENCE_LETTERS) {

						mutantCount++;
					}

				} else {

					countRow = 1;
					letterBeforeRow = matrix[x][y];
				}

				if (letterBeforeColumn.equals(matrix[y][x])) {

					countColumn++;

					if (countColumn == NUMER_SEQUENCE_LETTERS) {
						mutantCount++;
					}

				} else {
					countColumn = 1;
					letterBeforeColumn = matrix[y][x];
				}

				if (x == y) {
					if (letterBeforeDiagonal.equals(matrix[x][y])) {

						countDiagonal++;

						if (countDiagonal == NUMER_SEQUENCE_LETTERS) {
							mutantCount++;
						}

					} else {
						countDiagonal = 1;
						letterBeforeDiagonal = matrix[x][y];

					}
				}
			}

		}

		return false;

	}

}
