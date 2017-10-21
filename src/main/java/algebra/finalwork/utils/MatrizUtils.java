package algebra.finalwork.utils;

import algebra.finalwork.model.Matriz;

public class MatrizUtils {

	
public static Matriz createMatriz(Object[][] obj,int line,int column,boolean quadrada){
		
		Matriz matriz = new Matriz();
		
		matriz.setMatriz(obj);
		matriz.setLine(line);
		matriz.setColumn(column);
		matriz.setQuadrada(quadrada);
		
		return matriz;
	}
	
}
