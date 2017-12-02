package algebra.finalwork.simpleoperations;

import algebra.finalwork.model.Matriz;

public class SimpleOperations {

	public Matriz subtracao(Matriz A, Matriz B) {

		Matriz C = new Matriz();
		C.setColumn(A.getColumn());
		C.setLine(A.getLine());

		double[][] matriz = new double[A.getLine()][A.getColumn()];
		double[][] matrizA = A.getMatriz();
		double[][] matrizB = B.getMatriz();
		for (int i = 0; i < A.getLine(); i++) {
			for (int j = 0; j < A.getColumn(); j++) {
				double valueA = matrizA[i][j];
				double valueB = matrizB[i][j];
				matriz[i][j] = valueA - valueB;
			}
		}

		C.setMatriz(matriz);
		C.setQuadrada(true);

		return C;
	}

	public static double calculaIda(Matriz matriz) {
		int sum = 0;

		sum += matriz.getMatriz()[0][0] * matriz.getMatriz()[1][1] * matriz.getMatriz()[2][2];
		sum += matriz.getMatriz()[0][1] * matriz.getMatriz()[1][2] * matriz.getMatriz()[2][3];
		sum += matriz.getMatriz()[0][2] * matriz.getMatriz()[1][3] * matriz.getMatriz()[2][4];

		return sum;
	}

	public static double calculaVolta(Matriz matriz) {
		int sum = 0;
		
		
		sum +=  matriz.getMatriz()[0][4]* matriz.getMatriz()[1][3] *  matriz.getMatriz()[2][2];
		sum +=  matriz.getMatriz()[0][3]* matriz.getMatriz()[1][2] *  matriz.getMatriz()[2][1];
		sum +=  matriz.getMatriz()[0][2]* matriz.getMatriz()[1][1] *  matriz.getMatriz()[2][0];

	
		return sum;
	}

}
