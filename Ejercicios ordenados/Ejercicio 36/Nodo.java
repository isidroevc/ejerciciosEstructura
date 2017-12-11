public class Nodo<T> {
    private T dato;
    private Nodo siguiente;

    public Nodo(){}

    public Nodo(T dato){
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato){
        this.dato = dato;
    }

    public Nodo getSiguiente(){
        return this.siguiente;
    }

    public void setSiguiente(Nodo nodo){
        this.siguiente = nodo;
    }
}