public interface Listable<T>{
    public boolean esVacia();
    public void insertar (T element);
    public int localizar(T element);
    public T get(int i);
    //public T locate(T element);
    public void borrar(T element);
    public void borrar(int index);
    public T anterior(T element);
    public T siguiente(T element);
    public void vaciar();
}