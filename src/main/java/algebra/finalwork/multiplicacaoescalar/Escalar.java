package algebra.finalwork.multiplicacaoescalar;

public class Escalar {
public int[][] escalar(int[][] matriz1,int n, int m,int x) {
		
		int[][] aux = new int[n][m];
		for(int i = 0; i <= n-1; i++ ){
			for(int j = 0; j <= m-1; j++){
				aux[i][j] = x*matriz1[i][j];
			}
		}
		return aux;
	}
}


