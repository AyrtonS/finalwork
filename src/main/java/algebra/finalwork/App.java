package algebra.finalwork;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.simpleoperations.SimpleOperations;
import algebra.finalwork.transposicao.Transposicao;
import algebra.finalwork.utils.MatrizUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Object[][] matriz = new Object[2][2];
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[1][0] = 3;
		matriz[1][1] = 4;
		
		
		Object[][] matriz2 = new Object[2][2];
		matriz2[0][0] = 5;
		matriz2[0][1] = 3;
		matriz2[1][0] = 1;
		matriz2[1][1] = 9;
		
		Matriz matrizA = MatrizUtils.createMatriz(matriz, 2,2, true);
		Matriz matrizB = MatrizUtils.createMatriz(matriz2, 2,2, true);
		
		SimpleOperations so = new SimpleOperations();
		
		Matriz result = so.subtracao(matrizA,matrizB);
		
		
		Transposicao T = new Transposicao();
		matriz = T.transposicao(matriz, 2, 2);
		int m = 2,n = 2;
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 0; j <= m - 1; j++) {
				System.out.println(result.getMatriz()[i][j]);
			}
		}
	}
	
	

}
