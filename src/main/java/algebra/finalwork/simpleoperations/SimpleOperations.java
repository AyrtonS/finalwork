package algebra.finalwork.simpleoperations;

import algebra.finalwork.model.Matriz;

public class SimpleOperations {

	
	public Matriz subtracao(Matriz A,Matriz B){
		
		Matriz C = new Matriz();
		C.setColumn(A.getColumn());
		C.setLine(A.getLine());
		
		Object[][] matriz = new Object[A.getLine()][A.getColumn()];
		Object[][] matrizA = A.getMatriz();
		Object[][] matrizB = B.getMatriz();
 		for(int i = 0;i < A.getLine();i++){
			for(int j = 0; j < A.getColumn();j++){
				int valueA = (Integer) matrizA[i][j];
				int valueB = (Integer) matrizB[i][j];
				matriz[i][j] =  valueA - valueB; 
			}
		}
		
		C.setMatriz(matriz);
		C.setQuadrada(true);
		
		return C;
	}
	
}
