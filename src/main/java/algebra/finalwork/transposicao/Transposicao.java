package algebra.finalwork.transposicao;

public class Transposicao {

	public Object[][] transposicao(Object[][] matriz1,int n, int m) {
		for(int i = 0; i <= n-1; i++ ){
			for(int j = 0; j <= m-1; j++){
				//System.out.println(matriz1[i][j]);
				int x = (Integer) matriz1[j][i];
				matriz1[j][i] = matriz1[i][j];
				matriz1[i][j] = x;
				System.out.println(x);
			}
		}
		return matriz1;
	}
}