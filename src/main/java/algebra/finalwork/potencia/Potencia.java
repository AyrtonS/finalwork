package algebra.finalwork.potencia;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.multiplicacao.Multiplica;
import algebra.finalwork.transposicao.Transposicao;

public class Potencia {

	
	public static double[][] getExponentialMatrix(Matriz matriz,double exponentialValue){
		
		double[][] newMatriz = matriz.getMatriz();
		if(exponentialValue <= 0){
			return null;
		}
		if(exponentialValue == 1){
			return newMatriz;
		}
		
		if(matriz.getLine() == matriz.getColumn()){
			
			for(int i=0;i<exponentialValue-1;i++){	
				newMatriz = Multiplica.multiplica(newMatriz, newMatriz);					
				System.out.println(newMatriz);
			}		
			
			for(int i=0;i<matriz.getLine();i++){
				for(int j=0;j<matriz.getColumn();j++){
					System.out.print(newMatriz[i][j]+" | ");
				}
				System.out.println("");
			}
			
			
		}else if(matriz.getLine() > matriz.getColumn()){
			for(int i=0;i<exponentialValue-1;i++){	
				newMatriz = Multiplica.multiplica(newMatriz, Transposicao.transposicao(newMatriz, matriz.getLine(), matriz.getColumn()));					
				System.out.println(newMatriz);
			}		
			
			for(int i=0;i<matriz.getLine();i++){
				for(int j=0;j<matriz.getColumn();j++){
					System.out.print(newMatriz[i][j]+" | ");
				}
				System.out.println("");
			}
			
		}else{
			for(int i=0;i<exponentialValue-1;i++){	
				double[][] auxMatriz = Transposicao.transposicao(newMatriz, matriz.getLine(), matriz.getColumn());
				
				
				System.out.println("linhas : "+auxMatriz[0].length);
				System.out.println("colunas : "+auxMatriz.length);
				
				
				newMatriz = Multiplica.multiplicaPorTransposta(newMatriz ,auxMatriz);					
				System.out.println(newMatriz);
			}		
			
			for(int i=0;i<newMatriz[0].length;i++){
				for(int j=0;j<newMatriz.length;j++){
					System.out.print("linha "+i+ " : coluna "+j +newMatriz[i][j]+" | ");
				}
				System.out.println("");
			}
			
		}
		
		return newMatriz;
	}
	
	public static void main(String[] args) {
		
		double[][] a = new double[2][2];
		a[0][0] = 4.0;
		a[0][1] = 8.0;
		a[1][0] = 5.0;
		a[1][1] = 2.0;
		Matriz matriz = new Matriz();
		matriz.setMatriz(a);
		matriz.setColumn(2);
		matriz.setLine(2);
		
		getExponentialMatrix(matriz, 2);
 		
		
		
	}
}
