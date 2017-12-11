public interface Listable {
	public int tamanio();
    	public boolean estaVacia();
    	public boolean estaLlena();
    	public void vaciar();
    	public void agregar(Object e);
    	public void agregarAlInicio(Object e);
    	public boolean contiene(Object e);
    	public Object primerElemento();
    	public void eliminar(Object e);
    	public void sustituir(Object orig, Object nuevo);
    	public java.util.Iterator iterador();
}
