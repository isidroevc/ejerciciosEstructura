public class IdyLista {
    	public String nombre;
    	public Lista lista;

    	public IdyLista(String n) {
        		this.nombre=n;
        		this.lista=new Lista(500);
    	}

    	public IdyLista(String n, Lista l) {
        		this.nombre=n;
        		this.lista=l;
    	}

    	public String obtNombre() { return nombre; }

    	public Lista obtLista() { return lista; }
}
