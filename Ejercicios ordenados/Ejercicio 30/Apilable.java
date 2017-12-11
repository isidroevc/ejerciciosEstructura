public interface Apilable<T> {
    public void insertar(T e);
    public T quitar() throws Exception;
    public boolean esVacia();
    public void limpiar();
    public T cima();
    public int longitud();
}