public class Lista implements Listable {
    	private Nodo inicio;
    	private Nodo fin;
    	private int tamanio;
    	private final int capacidad;
    
    	public Lista(int c) {
        		this.inicio=null;
        		this.fin=null;
        		this.tamanio=0;
        		this.capacidad=c;
    	}

   	@Override
    	public int tamanio() { return tamanio; }

   	@Override
    	public boolean estaVacia() { return inicio==null && fin==null; }
    
    	@Override
    	public boolean estaLlena() { return tamanio==capacidad; }

    	@Override
    	public void vaciar() {
        		inicio=fin=null;
        		tamanio=0;
    	}

    	@Override
    	public Object primerElemento() { return (estaVacia())?null:inicio.elemento;}

    	public Object ultimoElemento() { return (estaVacia())?null:fin.elemento; }

    	@Override
    	public boolean contiene(Object e) {
        		Nodo pos=inicio;
        		while (pos!=null && !e.equals(pos.elemento)) pos=pos.siguiente;
        		return pos!=null;
    	}

    	@Override
    	public void sustituir(Object orig, Object nuevo) {
        		Nodo pos=inicio;
        		while (pos!=null && !orig.equals(pos.elemento)) pos=pos.siguiente;
        		if (pos!=null) pos.elemento=nuevo;
    	}

    	@Override
    	public void agregarAlInicio(Object e) {
        		if (estaVacia()) inicio=fin=new Nodo(e);
        		else if (!estaLlena()) inicio=new Nodo(e, inicio);
    	}

    	@Override
    	public void agregar(Object e) {
        		if (estaVacia()) inicio=fin=new Nodo(e);
        		else if (!estaLlena()) fin=fin.siguiente=new Nodo(e);
    	}

    	@Override
    	public void eliminar(Object e) {
        		Nodo pos=inicio,anterior=null;
        		while (pos!=null && !e.equals(pos.elemento)) {
            			anterior=pos;
            			pos=pos.siguiente;
        		}
        		if (pos==null) return;
        		if (pos==inicio) {
            			inicio=inicio.siguiente;
            			if (inicio==null) fin=null;
        		} else {
            			anterior.siguiente=pos.siguiente;
            			if (anterior.siguiente==null) fin=anterior;
        		}
    	}

    	public void eliminarPrimero() {
        		if (!estaVacia()) {
            			inicio=inicio.siguiente;
            			if (inicio==null) fin=null;
        		}
    	}

    	public void imprime() {
        		if (estaVacia()) System.out.print("La lista está vacía.");
        		else {
            			for (Nodo pos=inicio; pos!=null; pos=pos.siguiente)
                		System.out.print(pos.elemento+" ");
            			System.out.println();
        		}
    	}
    
    	@Override
    	public java.util.Iterator iterador() { return new MiIterador(); }

    	private class MiIterador implements java.util.Iterator {
        		private Nodo posicion=inicio;

        		@Override
        		public boolean hasNext() { return posicion!=null; }

        		@Override
        		public Object next() {
            			if (hasNext()) {
                			Object o=posicion.elemento;
                			posicion=posicion.siguiente;
                			return o;
            			}
            			return null;
        		}

        		@Override
        		public void remove() { throw new IllegalStateException(); }
    	}
}
