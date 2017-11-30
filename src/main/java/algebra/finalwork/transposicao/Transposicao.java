package algebra.finalwork.transposicao;

public class Transposicao {

	public static Object[][] transposicao(Object[][] matriz1,int n, int m) {
		
		Object[][] aux = new Object[m][n];
		for(int i = 0; i < m; i++ ){
			for(int j = 0; j < n; j++){
				//System.out.println(matriz1[j][i]);
				aux[i][j] = matriz1[j][i];
			}
		}
		return aux;
	}

	public static void main(String[] args) {
		Object[][] o = new Object[2][3];
		
		o[0][0] = 1;
		o[0][1] = 2;
		o[0][2] = 3;
		o[1][0] = 4;
		o[1][1] = 5;
		o[1][2] = 6;
		
		Object[][] d = transposicao(o, 2, 3);
		for(int i = 0; i < 3; i++ ){
			for(int j = 0; j < 2; j++){
				System.out.print(d[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}
		
		
		
	}
	
}