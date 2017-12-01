package algebra.finalwork.multiplicacao;

public class Multiplica {
	public static double[][] multiplica(Object[][] matriz1, Object[][] matriz2) {
        int m1 = matriz1.length;
        int n1 = matriz1[0].length;
        int m2 = matriz2.length;
        int n2 = matriz2[0].length;
        if (n1 != m2) throw new RuntimeException("Matrizes incompatíveis");
        double[][] resultado = new double[m1][n2];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2; j++)
                for (int k = 0; k < n1; k++){
                	double a = (double) matriz1[i][k];
                	double b = (double) matriz2[k][j];
                	resultado[i][j] += a * b;
                	
                }
                	
       
        return resultado;
    }

}
