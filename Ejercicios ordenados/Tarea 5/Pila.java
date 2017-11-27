public class Pila<Tipo> implements Apilable<Tipo> {
    private int cuenta;
    private Nodo<Tipo> cima;

    public Pila() { }

    public Pila(Tipo[] arreglo) {
        for(int i = arreglo.length - 1; i > -1; i--) {
            this.insertar(arreglo[i]);
        }
    }

    @Override
    public void insertar(Tipo elemento) {
        Nodo<Tipo> aux = null;
        
        if(this.cima == null) 
            this.cima = new Nodo<>(elemento);
        else {
            aux = this.cima;
            this.cima = new Nodo<>(elemento);
            this.cima.setSiguiente(aux);
        }    
        cuenta++;
    }

    @Override
    public Tipo quitar() throws Exception{
        Nodo<Tipo> aux ;
        Tipo datoAux;

        if(this.cima == null) 
            throw new Exception("Desbordamiento de pila");
        else {
            aux = this.cima;
            this.cima = this.cima.getSiguiente();
            datoAux = aux.getDato();
            aux = null;
            cuenta--;
            return datoAux;
        }
    }

    public boolean esVacia() { return this.cima == null; }

    public void limpiar() {
        try {
            while(this.cima != null)
                this.quitar();
            this.cuenta = 0;
        } catch(Exception ex) { }
    }

    @Override
    public Tipo cima() { 
        //if(cima != null ) 
            return this.cima.getDato(); 
        /*else 
            return null;*/
    }

    @Override
    public int longitud() { return this.cuenta; }

    @Override
    public String toString() {
        Nodo<Tipo> actual;
        String result = "[";
        actual = this.cima;

        if(actual == null)
            return "[]";

        while(actual != null) {
            result += actual.getDato().toString();
            if(actual.getSiguiente() != null) 
                result += ", ";
            actual = actual.getSiguiente();
        }
        result += "]";
        return result;
    }
}