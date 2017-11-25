package algebra.finalwork.transposicao;

public class Transposicao {

	public static Object[][] transposicao(Object[][] matriz1,int n, int m) {
		
		Object[][] aux = new Object[n][m];
		for(int i = 0; i <= n-1; i++ ){
			for(int j = 0; j <= m-1; j++){
				System.out.println(matriz1[j][i]);
				aux[i][j] = matriz1[j][i];
			}
		}
		return aux;
	}

	
}