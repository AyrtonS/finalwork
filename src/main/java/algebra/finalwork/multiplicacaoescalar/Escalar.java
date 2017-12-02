package algebra.finalwork.multiplicacaoescalar;

public class Escalar {
public double[][] escalar(double[][] matriz1,int n, int m,int x) {
		
	double[][] aux = new double[n][m];
		
		try{
			
			
			for(int i = 0; i < n; i++ ){
				for(int j = 0; j < m; j++){
					int matrizValue = (int) matriz1[j][i];
					aux[i][j] = x*matrizValue;
					System.out.println(aux[i][j]);
				}
			}
			return aux;
		}catch(IndexOutOfBoundsException e){
			System.err.println(e.getMessage());
			return aux;
		}
	
	}
}


