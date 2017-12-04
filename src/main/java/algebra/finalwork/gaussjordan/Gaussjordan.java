package algebra.finalwork.gaussjordan;

public class Gaussjordan {
	public static double[][] matrizAumentada;

	
	public Gaussjordan(double[][] matrix) {
		matrizAumentada = matrix;
	}

	
	public double[][] eliminate() {
		int startColumn = 0;
		for (int row = 0; row < matrizAumentada.length; row++) {
			while (matrizAumentada[row][startColumn] == 0.0) {
				boolean switched = false;
				int i = row;
				while (!switched && i < matrizAumentada.length) {
					if (matrizAumentada[i][startColumn] != 0.0) {
						double[] temp = matrizAumentada[i];
						matrizAumentada[i] = matrizAumentada[row];
						matrizAumentada[row] = temp;
						switched = true;
					}
					i++;
				}
				if (matrizAumentada[row][startColumn] == 0.0) {
					startColumn++;
				}
			}
			if (matrizAumentada[row][startColumn] != 1.0) {
				double divisor = matrizAumentada[row][startColumn];
				for (int i = startColumn; i < matrizAumentada[row].length; i++) {
					matrizAumentada[row][i] = matrizAumentada[row][i] / divisor;
				}
			}
			// Certifica que o numero na coluna de inicio possuem zeros.
			for (int i = 0; i < matrizAumentada.length; i++) {
				if (i != row && matrizAumentada[i][startColumn] != 0) {
					double multiple = 0 - matrizAumentada[i][startColumn];
					for (int j = startColumn; j < matrizAumentada[row].length; j++) {
						matrizAumentada[i][j] += multiple * matrizAumentada[row][j];
					}
				}
			}
			startColumn++;
		}
		
		return matrizAumentada;
	}
	
	public String toString() {
		String text = "";
		for (int i = 0; i < matrizAumentada.length; i++) {
			for (int j = 0; j < matrizAumentada[i].length; j++) {
				text += matrizAumentada[i][j] + ", ";
			}
			text += "\n";
		}
		return text;
	}

	public static void main(String[] args) {
		double[][] matriz1 = { { 1, 2, -3, 5 }, { -2, 1, -4, -2 }, { 1, -3, 5, -1 } };
		Gaussjordan example = new Gaussjordan(matriz1);
		example.eliminate();
		System.out.println(example);
	}

}
