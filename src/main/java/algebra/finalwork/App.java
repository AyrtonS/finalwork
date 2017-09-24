package algebra.finalwork;

import algebra.finalwork.transposicao.Transposicao;

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

		Transposicao T = new Transposicao();
		matriz = T.transposicao(matriz, 2, 2);
		int m = 2,n = 2;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				//System.out.println(matriz[i][j]);
			}
		}
	}

}
