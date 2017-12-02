package algebra.finalwork.inversa;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.transposicao.Transposicao;


public class Inversa {
	
	private Matriz inverse = new Matriz();
	private Matriz transposed = new Matriz();
	
	
	public Matriz getInverted2x2Matrix(Matriz matriz){
	
		if(matriz.isQuadrada() && matriz.getLine()==2){
			
			double[][] auxiliarMatrix = new double[matriz.getLine()][matriz.getColumn()];
			double[][] originalMatrix = matriz.getMatriz();
			
			auxiliarMatrix[0][0] = originalMatrix[1][1];
			auxiliarMatrix[1][1] = originalMatrix[0][0];
			auxiliarMatrix[0][1] = originalMatrix[0][1] * (-1);
			auxiliarMatrix[1][0] = originalMatrix[1][0] * (-1); 
			
			
			
			inverse.setColumn(matriz.getColumn());
			inverse.setLine(matriz.getColumn());
			inverse.setMatriz(auxiliarMatrix);
			inverse.setQuadrada(true);
			
			Transposicao transposicao = new Transposicao();
			double[][] transposedMatrix = new double[matriz.getLine()][matriz.getColumn()];
			
			
			transposedMatrix = transposicao.transposicao(inverse.getMatriz(), inverse.getLine(), inverse.getColumn());
			transposed.setColumn(inverse.getLine());
			transposed.setLine(inverse.getColumn());
			transposed.setMatriz(transposedMatrix);
			
			inverse.setTransposta(transposed);
			matriz.setInversa(inverse);
			
			return inverse;
		}else{
			return null;
		}
		
	
	}
	

	
}
