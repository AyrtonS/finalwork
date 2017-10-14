package algebra.finalwork.model;

public class Matriz {

	private int line;
	private int column;
	private Object[][] matriz;
	
	private Matriz transposta;
	private Matriz inversa;
	private boolean quadrada;
	
	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public Matriz getTransposta() {
		return transposta;
	}
	
	public void setTransposta(Matriz transposta) {
		this.transposta = transposta;
	}
	
	public Matriz getInversa() {
		return inversa;
	}
	
	public void setInversa(Matriz inversa) {
		this.inversa = inversa;
	}

	public Object[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Object[][] matriz) {
		this.matriz = matriz;
	}

	public boolean isQuadrada() {
		return quadrada;
	}

	public void setQuadrada(boolean quadrada) {
		this.quadrada = quadrada;
	}
	
	
	
	
	
}
