package algebra.finalwork.inversaatual;

public class InversaAtual {
	public static double[][] invertMatrix (double[][] matrix) {
		double[][] auxiliaryMatrix, invertedMatrix;
		int[] index;

		auxiliaryMatrix = new double[matrix.length][matrix.length];
		invertedMatrix = new double[matrix.length][matrix.length];
		index = new int[matrix.length];

		for (int i = 0; i < matrix.length; ++i) {
			auxiliaryMatrix[i][i] = 1;
		}

		transformToUpperTriangle (matrix, index);

		for (int i = 0; i < (matrix.length - 1); ++i) {
			for (int j = (i + 1); j < matrix.length; ++j) {
				for (int k = 0; k < matrix.length; ++k) {
					auxiliaryMatrix[index[j]][k] -= matrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
				}
			}
		}

		for (int i = 0; i < matrix.length; ++i) {
			invertedMatrix[matrix.length - 1][i] = (auxiliaryMatrix[index[matrix.length - 1]][i] / matrix[index[matrix.length - 1]][matrix.length - 1]);

			for (int j = (matrix.length - 2); j >= 0; --j) {
				invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

				for (int k = (j + 1); k < matrix.length; ++k) {
					invertedMatrix[j][i] -= (matrix[index[j]][k] * invertedMatrix[k][i]);
				}

				invertedMatrix[j][i] /= matrix[index[j]][j];
			}
		}

		return (invertedMatrix);
	}
	public static void transformaEmTriangularSuperior (double[][] matrix, int[] index) {
		double[] c;
		double c0, c1, pi0, pi1, pj;
		int itmp, k;

		c = new double[matrix.length];

		for (int i = 0; i < matrix.length; ++i) {
			index[i] = i;
		}

		for (int i = 0; i < matrix.length; ++i) {
			c1 = 0;

			for (int j = 0; j < matrix.length; ++j) {
				c0 = Math.abs (matrix[i][j]);

				if (c0 > c1) {
					c1 = c0;
				}
			}

			c[i] = c1;
		}

		k = 0;

		for (int j = 0; j < (matrix.length - 1); ++j) {
			pi1 = 0;

			for (int i = j; i < matrix.length; ++i) {
				pi0 = Math.abs (matrix[index[i]][j]);
				pi0 /= c[index[i]];

				if (pi0 > pi1) {
					pi1 = pi0;
					k = i;
				}
			}

			itmp = index[j];
			index[j] = index[k];
			index[k] = itmp;

			for (int i = (j + 1); i < matrix.length; ++i) {
				pj = matrix[index[i]][j] / matrix[index[j]][j];
				matrix[index[i]][j] = pj;

				for (int l = (j + 1); l < matrix.length; ++l) {
					matrix[index[i]][l] -= pj * matrix[index[j]][l];
				}
			}
		}
	}
	public static void main (String[] args) {
		double matrix[][] = {
				{2, 3},
				{2,5}
				//{-100, -100, 300,},
		};
InversaAtual I = new InversaAtual();
		double invertedMatrix[][] = I.invertMatrix(matrix);
		for(int i = 0; i < 2;i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(invertedMatrix[i][j]+" | ");
			}
			System.out.println("");
		}

		
	}
}
