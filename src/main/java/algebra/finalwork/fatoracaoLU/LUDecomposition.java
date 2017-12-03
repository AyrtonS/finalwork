package algebra.finalwork.fatoracaoLU;

import java.util.HashMap;

import algebra.finalwork.model.Matriz;

public class LUDecomposition {
	
	public static  HashMap<String, double[][]> mappingLU = new HashMap<>();
	
	public static HashMap<String, double[][]> LUDecompositonMethod(Matriz matriz,int matrixDimension) {
		double[][] mat = new double[matrixDimension][matrixDimension];
		for (int i = 0; i < matrixDimension; i++)
			for (int j = 0; j < matrixDimension; j++)
				mat[i][j] = matriz.getMatriz()[i][j];

		if (matrixDimension == 2) {
			double[][] l = new double[matrixDimension][matrixDimension];
			l[0][0] = l[1][1] = 1;
			l[0][1] = 0;

			double[][] u = new double[matrixDimension][matrixDimension];
			u[1][0] = 0;

			u[0][0] = mat[0][0];
			u[0][1] = mat[0][1];

			l[1][0] = mat[1][0] / mat[0][0];
			u[1][1] = mat[1][1] - (l[1][0] * u[0][1]); // mat[2][2]-(mat[2][1]*mat[1][2]/mat[1][1]);
			
			
			mappingLU.put("L", l);
			mappingLU.put("U", u);
			

		}
		if (matrixDimension == 3) {
			double[][] l = new double[matrixDimension][matrixDimension];
			l[0][0] = l[1][1] = l[2][2] = 1;
			l[0][1] = l[0][2] = l[1][2] = 0;

			double[][] u = new double[matrixDimension][matrixDimension];
			u[1][0] = u[2][0] = u[2][1] = 0;

			u[0][0] = mat[0][0];
			u[0][1] = mat[0][1];
			u[0][2] = mat[0][2];

			l[1][0] = mat[1][0] / mat[0][0];
			u[1][1] = mat[1][1] - (l[1][0] * u[0][1]); // mat[2][2]-(mat[2][1]*mat[1][2]/mat[1][1]);
			u[1][2] = mat[1][2] - (l[1][0] * u[0][2]);

			l[2][0] = mat[2][0] / u[0][0];
			l[2][1] = (mat[2][1] - l[2][1] * u[0][1]) / u[1][1];
			u[2][2] = mat[2][2] - (l[2][0] * u[0][2]) - (l[2][1] * u[1][2]);

			mappingLU.put("L", l);
			mappingLU.put("U", u);


		}
		return mappingLU;
	}
}
