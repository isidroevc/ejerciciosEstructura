public class Nodo {
    	public Object elemento;
    	public Nodo siguiente;

    	public Nodo(Object e) { this.elemento=e; }

    	public Nodo(Object e, Nodo n) {
        		this.elemento=e;
        		this.siguiente=n;
    	}

    	public Object obtenerElemento() { return elemento; }

    	public Nodo obtenerSgte() { return siguiente; }
}
