public interface Encolable<T> {
    public void insertar(T e);
    public boolean quitar(int i);
    public boolean esVacia();
    public T frente();
}