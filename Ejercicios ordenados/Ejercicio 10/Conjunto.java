public class Conjunto implements Conjuntable{
	//Elementos del conjunto
	private String conjunto[];
	
	//Constructores ------------------------------------------------------------
	public Conjunto() {
		conjunto = null;
	}
	public Conjunto(Conjunto b) {
		conjunto = b.conjunto;
	}
	public Conjunto(int n) {
		conjunto = new String[n];
	}
	//Acceso-------------------------------------------------------------------
	public void setElemento(String elemento, int posicion) {
		cardinalidadPermitida(posicion);
		conjunto[posicion] = elemento;
	}
	public void setElementos(String[] elementos) {
		conjunto = elementos;
	}
	public String getElemento(int posicion) {
		cardinalidadPermitida(posicion);
		return conjunto[posicion];
	}
	public String[] getElementos() {
		return conjunto;
	}
	public int getCardinalidad() {
		return conjunto.length;
	}
	//Axiomas-------------------------------------------------------------------
	void cardinalidadPermitida(int pos) {
		try {
			conjunto[pos] = conjunto[pos];		
		} catch (ArrayIndexOutOfBoundsException aibe) {
			System.out.println("Se ha salido de la cardinalidad del conjunto.");
			System.exit(0);
		}
	}
	//Operaciones --------------------------------------------------------------
	public Conjunto union(Conjunto a, Conjunto b) {
		//Cardinalidad de la union
		int cardinalidad = 0;
		for(String x: a.getElementos()) 
			for(String y: b.getElementos()) 
				if(y.equals(x)) cardinalidad++;
		cardinalidad = a.getCardinalidad() + b.getCardinalidad() - cardinalidad;
		// Unir los conjuntos en un nuevo conjunto
		int posicion = a.getCardinalidad();
		boolean repetido;
		String[] elementos = new String[cardinalidad];
		for(int i = 0; i < a.getCardinalidad(); i++)
			elementos[i] = a.getElemento(i);	
		for(int i = 0; i < b.getCardinalidad(); i++) {
			repetido = false;
			for(String x: a.getElementos()) 
				if(x.equals(b.getElemento(i))) repetido = true;
			if(!repetido){
				elementos[posicion] = b.getElemento(i);
				posicion++;
			}
				
		}		
		Conjunto c = new Conjunto();
		c.setElementos(elementos);
		return c;
	}

	public Conjunto interseccion(Conjunto a, Conjunto b) {
		//Cardinalidad de la interseccion
		int cardinalidad = 0;
		for(String x: a.getElementos()) 
			for(String y: b.getElementos()) 
				if(y.equals(x)) cardinalidad++;
		// Colocar los elementos distintos en un nuevo conjunto
		String[] elementos = new String[cardinalidad];
		int posicion = 0;
		for(String x: a.getElementos()) 
			for(String y: b.getElementos())
				if(y.equals(x)) {
					elementos[posicion] = y;
					posicion++;
				}
		Conjunto c = new Conjunto();
		c.setElementos(elementos);
		return c;
	}

	public Conjunto diferencia(Conjunto a, Conjunto b) {
		//Cardinalidad de la diferencia
		int cardinalidad = 0;
		for(String x: a.getElementos()) 
			for(String y: b.getElementos()) 
				if(y.equals(x)) cardinalidad++;
		cardinalidad = a.getCardinalidad() - cardinalidad;
		// Colocar los elementos de A que no estan en B
		String[] elementos = new String[cardinalidad];
		int posicion = 0;
		boolean repetido;
		for(String x: a.getElementos()) {
			repetido = false;
			for(String y: b.getElementos()) 
				if(x.equals(y)) repetido = true;
			if(!repetido) {
				elementos[posicion] = x;
				posicion++;
			}
		}
		Conjunto c = new Conjunto();
		c.setElementos(elementos);
		return c;
	}

	public Conjunto diferenciaSimetrica(Conjunto a, Conjunto b) {
		Conjunto union = new Conjunto();
		Conjunto interseccion = new Conjunto();
		Conjunto diferencia = new Conjunto();
		union = union.union(a, b);
		interseccion = interseccion(a,b);
		diferencia = diferencia(union, interseccion);
		String[] elementos = diferencia.getElementos();
		Conjunto c = new Conjunto();
		c.setElementos(elementos);
		return c;
	}

	public Conjunto complemento(Conjunto universo, Conjunto a) {
		if(a.getCardinalidad() > universo.getCardinalidad()){
			System.out.println("El conjunto universo no puede ser menor que"
					+ " el conjunto A");
			return new Conjunto(0);
		}
		Conjunto c = new Conjunto();
		c = c.diferencia(universo, a);
		return c;
	}
}
