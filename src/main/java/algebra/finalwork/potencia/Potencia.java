package algebra.finalwork.potencia;

import algebra.finalwork.model.Matriz;

public class Potencia {

	
	public static double[][] getExponentialMatrix(Matriz matriz,double exponentialValue){
		
		double[][] newMatriz = new double[matriz.getLine()][matriz.getColumn()];
		
		for(int i=0;i<matriz.getLine();i++){
			for(int j=0;j<matriz.getColumn();j++){
				newMatriz[i][j] = Math.pow(matriz.getMatriz()[i][j], exponentialValue);
				System.out.print(newMatriz[i][j]+" | ");
			}
			System.out.println("");
		}		
		return newMatriz;
	}
	
	public static void main(String[] args) {
		
		double[][] a = new double[2][2];
		a[0][0] = 4;
		a[0][1] = 8;
		a[1][0] = 5;
		a[1][1] = 2;
		Matriz matriz = new Matriz();
		matriz.setMatriz(a);
		matriz.setColumn(2);
		matriz.setLine(2);
		
		getExponentialMatrix(matriz, 4);
 		
		
		
	}
}
