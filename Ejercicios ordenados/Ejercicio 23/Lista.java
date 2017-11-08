public class Lista<Ty> implements Listable<Ty>{
    private Nodo<Ty> primero;
    private int cuenta;

    public Lista(){
        this.primero = new Nodo<Ty>();
    }
    
    public Lista(Ty f){
        this.primero = new Nodo<Ty>(f);
    }

    public Ty getPrimero() {
        return this.primero.getDato();
    }

    @Override
    public boolean esVacia(){
        return this.primero == null;
    }

    @Override
    public void insertar(Ty elemento){
        Nodo<Ty> actual = null;
        Nodo<Ty> entrada = new Nodo<>(elemento);

        if(this.primero.getDato() == null){
            actual = this.primero;
            actual.setDato(elemento);
        }
        else {
            actual = this.primero;
            while(actual.getSiguiente() != null)
                actual = actual.getSiguiente();
            actual.setSiguiente(entrada);
        }
        cuenta++;
    }

    @Override
    public Ty get(int i) {
        Nodo actual = primero;
        
        for(int j = 0; j < i; j++)
            actual = actual.getSiguiente();
        return (Ty)actual.getDato();
    }

    @Override
    public int localizar(Ty elemento){
        Nodo actual = this.primero;
        int i = -1;

        while(actual != null) {
            i++;
            if(actual.getDato().equals(elemento))
                break;
            actual = actual.getSiguiente();      
        } 
        if(i == this.cuenta)
            i = -1;
        return i;
    }

    @Override 
    public void borrar(Ty elemento){

    }

    @Override
    public void borrar(int index){
        Nodo actual = this.primero;
        Nodo anterior = null;
        int i = 0;

        while(actual != null) {
            if(index == i) {
                anterior.setSiguiente(actual.getSiguiente());
                actual = null;
                cuenta--;
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();  
            i++;    
        } 
    }

    @Override
    public Ty anterior(Ty element){
        Ty ret = null;
        return ret;
    }
    
    @Override
    public Ty siguiente(Ty element){
        Ty ret = null;
        return ret;
    }

    @Override
    public void vaciar(){

    }
}