package algebra.finalwork.multiplicacao;

public class Multiplica {
	public static double[][] multiplica(double[][] matriz1, double[][] matriz2) {
		int m1 = matriz1.length;
		int n1 = matriz1[0].length;
		
		int m2 = matriz2.length;
		int n2 = matriz2[0].length;
		System.out.println("matriz1: "+n1 + " | "+m2);
		if (n1 != m2)
			throw new RuntimeException("Matrizes incompatíveis");
		double[][] resultado = new double[n2][m1];
		for (int i = 0; i <= m1 - 1; i++)
			for (int j = 0; j <= n2 - 1; j++)
				for (int k = 0; k <= n1 - 1; k++) {
					double a =  matriz1[i][k];
					double b =  matriz2[k][j];
					resultado[i][j] += a * b;

				}

		return resultado;
	}
	
	public static double[][] multiplicaPorTransposta(double[][] matriz1, double[][] matriz2) {
		int m1 = matriz1.length;
		int n1 = matriz1[0].length;
		int m2 = matriz2.length;
		int n2 = matriz2[0].length;
		System.out.println("matriz1: "+n1 + " | "+m2);
		if (n1 != m2)
			throw new RuntimeException("Matrizes incompatíveis");
		double[][] resultado = new double[n1+1][m2+1];
		for (int i = 0; i <= m1 - 1; i++)
			for (int j = 0; j <= n2 - 1; j++)
				for (int k = 0; k <= n1 - 1; k++) {
					double a =  matriz1[i][k];
					double b =  matriz2[k][j];
					resultado[i][j] += a * b;

				}

		return resultado;
	}

	/*public static void main(String[] args) {
		Object[][] obj = new Object[2][2];
		Object[][] obj2 = new Object[2][2];

		obj[0][0] = 1.0;
		obj[0][1] = 3.0;
		obj[1][0] = 4.0;
		obj[1][1] = 18.0;

		obj2[0][0] = 8.0;
		obj2[0][1] = 4.0;
		obj2[1][0] = 5.0;
		obj2[1][1] = 6.0;

		double[][] result = multiplica(obj, obj2);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(result[i][j]);
			}
		}

	}
*/
}
