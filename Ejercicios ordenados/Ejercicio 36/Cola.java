public class Cola<Ty> implements Encolable<Ty> {
    private Nodo<Ty> frente;
    private int longitud;

    
    public int longitud(){
        return longitud;
    }

    @Override
    public void insertar(Ty e) {
        Nodo frenteAnterior = null;

        if(frente == null)
            this.frente = new Nodo<>(e);
        else {
            frenteAnterior = this.frente;
            this.frente = new Nodo<>(e);
            this.frente.setSiguiente(frenteAnterior);
        }
        longitud++;
    }

    @Override
    public boolean quitar(int i){
        Nodo actual = this.frente;
        Nodo anterior = null;
        int indiceActual  = 0;
        boolean eliminado = false;
        if(i > longitud)
            return false;
        while(actual != null) {
            if(indiceActual == i) {
                if(indiceActual == 0){
                    this.frente = actual.getSiguiente();
                    actual = null;
                    eliminado = true;
                    break;
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    actual = null;
                    eliminado = true;
                    break;
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
            indiceActual++;
        }
        if(eliminado)
            longitud--;
        return eliminado;
    }

    @Override
    public boolean esVacia() { return this.frente == null; }

    @Override
    public Ty frente() {
        Ty resultado = this.frente.getDato();
        Nodo aux = this.frente;
        this.frente = this.frente.getSiguiente();
        aux = null;
        longitud--;
        return resultado;
    }

    @Override
    public String toString() {
        Nodo actual = this.frente;
        String resultado = "[";
        int i = 0;
        while(actual != null) {
            resultado += actual.getDato().toString();
            actual = actual.getSiguiente();
            if( i != longitud - 1)
                resultado += ", ";
            i++;
        }
        resultado += "]";
        return resultado;
    }

}