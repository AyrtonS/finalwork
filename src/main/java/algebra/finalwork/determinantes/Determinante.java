package algebra.finalwork.determinantes;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.simpleoperations.SimpleOperations;
import javafx.stage.StageStyle;

public class Determinante {

	public static double determinante2x2(Matriz matriz) {

		double[][] m1 = matriz.getMatriz();
		return m1[0][0] * m1[1][1] - m1[0][1] * m1[1][0];

	}

	public static double determinante3X3(Matriz matriz) {

		matriz.setMatriz(constroiMatriz3x5(matriz));
		double somaIda = SimpleOperations.calculaIda(matriz);
		System.out.println("Soma ida = "+somaIda);
		double somaVolta = SimpleOperations.calculaVolta(matriz);
		System.out.println("Soma volta = "+somaVolta);

		return somaIda - somaVolta;
	}

	private static double[][] constroiMatriz3x5(Matriz matriz) {
		double[][] m1 = matriz.getMatriz();

		int i = 0;
		int j = 0;
		int k = 5;

		double[][] m2 = new double[3][5];
		double[][] aux = new double[3][2];

		for (int v = 0; v <= matriz.getLine() - 1; v++) {
			for (int w = 0; w <= matriz.getColumn() - 1; w++) {
				if (v < 3 && w < 2)
					aux[v][w] = (double) m1[v][w];
		
				m2[v][w] = (double) m1[v][w];
			}
		}

		try {
			for (int r = 0; r < m2[0].length; r++) {
				for (int s = 0; s < m2.length; s++) {
					System.out.print(m2[r][s]+" | ");
				}
				System.out.println("");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		
		int count = 0;
		for (int v = 0; v < 3; v++) {
			for (int w = 3; w < 5; w++) {
				if (count == 2)
					break;
				m2[v][w] = aux[v][count];
				count++;
			}
			count =0;
		}

		System.out.println("length columns = "+m2[0].length + " | length line"+m2.length);
		
		for (int r = 0; r < m2.length; r++) {
			for (int s = 0; s < m2[0].length; s++) {
				System.out.print(m2[r][s]+" | ");
			}
			System.out.println("");
		}

		return m2;
	}

	public static void main(String[] args) {
		double[][] obj = new double[5][5];
		obj[0][0] = 2.0;
		obj[0][1] = 4.0;
		obj[0][2] = 5.0;
		obj[1][0] = 6.0;
		obj[1][1] = 7.0;
		obj[1][2] = 8.0;
		obj[2][0] = 9.0;
		obj[2][1] = 10.0;
		obj[2][2] = 11.0;

		Matriz matriz = new Matriz();
		matriz.setMatriz(obj);
		matriz.setLine(3);
		matriz.setColumn(3);

		System.out.println(determinante3X3(matriz));

	}

}
