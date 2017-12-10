package algebra.finalwork.transposicao;

public class Transposicao {

	public static double[][] transposicao(double[][] matriz1,int n, int m) {
		
		double[][] aux = new double[m][n];
		for(int i = 0; i < m; i++ ){
			for(int j = 0; j < n; j++){
				System.out.println("i "+i +" j "+j );
				aux[i][j] = matriz1[j][i];
				System.out.println(aux[i][j]+" | ");
			}
			System.out.println("");
		}
		return aux;
	}

	public static void main(String[] args) {
		double[][] o = new double[2][3];
		
		o[0][0] = 1;
		o[0][1] = 2;
		o[0][2] = 3;
		o[1][0] = 4;
		o[1][1] = 5;
		o[1][2] = 6;
		
		double[][] d = transposicao(o, 2, 3);
		for(int i = 0; i < 3; i++ ){
			for(int j = 0; j < 2; j++){
				System.out.print(d[i][j]);
				System.out.print("|");
			}
			System.out.println("");
		}
		
		
		
	}
	
}