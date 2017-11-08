/**
    Instituto Tecnológico de León.
    Ingenieria En Sistemas Computacionales.
    Estructura de datos.
    Maestro: Ing. Cirino Silva Tovar.
    Alumno Vásquez Cortés Isidro Emmanuel
    Ejercicio 11.
    Fecha de elaboración 22/10/2017
 */
import java.util.ArrayList;
public class Conjunto implements Conjuntable {
    private ArrayList<Object> elementos;
    private int cardinalidad;

    public Conjunto() {}

    public Conjunto(ArrayList<Object> elementos){
        this.elementos = elementos;
        quitarRepetidos();
    }

    public ArrayList<Object> getElementos() { return this.elementos; }

    public void setElementos(ArrayList<Object> elementos){
        this.elementos = elementos;
        quitarRepetidos();
    }

    public int getCardinalidad() {
        return this.elementos.size();
    }
    // -Implementaciones de la interfaz

    @Override
    public Conjunto union(Conjunto c){
        ArrayList<Object> arr = c.getElementos();
        ArrayList<Object> result = (ArrayList<Object>)this.elementos.clone();
        int k = arr.size();
        for(int i =0; i < k; i++)
            result.add(arr.get(i));
        return new Conjunto(result);
    }

    @Override
    public Conjunto interseccion(Conjunto c){
        ArrayList<Object> arr = c.getElementos();
        ArrayList<Object> result = new ArrayList<>();
        Object current, compare;
        int k = arr.size();
        int l = this.elementos.size();
        for(int i = 0; i < l; i++){
            current = this.elementos.get(i);
            for(int j = 0; j < k; j++){
                compare = arr.get(j);
                if(current.equals(compare))
                    result.add(compare);
            }
        }
        return new Conjunto(result);
    }
    @Override
    public Conjunto diferencia(Conjunto c){
        ArrayList<Object> arr = c.getElementos();
        ArrayList<Object> result = (ArrayList<Object>)this.elementos.clone();
        Object current, compare;
        int k = arr.size();
        int l = this.elementos.size();
        if(arr.size() == 0)
            return (Conjunto)this.clone();
        else
            for(int i = 0; i < l; i++){
                 current = this.elementos.get(i);
                for(int j = 0; j < k; j++){
                    compare = arr.get(j);
                    if(current.equals(compare))
                        result.remove(compare);
                }
            }
        return new Conjunto(result);
    }

    @Override
    public Conjunto diferenciaSimetrica(Conjunto c) {
        Conjunto aux1 = this.union(c);
        Conjunto aux2 = this.interseccion(c);
        return aux1.diferencia(aux2);
    }

    @Override 
    public String toString() {
        int c = this.elementos.size();
        String result = "{";
        for(int i =0; i < c; i++){
            result += this.elementos.get(i);
            if(i != c-1)
                result += ",";
        }
        result += "}";
        return result;
    }

    @Override
    public Object clone() {
        return new Conjunto((ArrayList<Object>)this.elementos.clone());
    }

    public void quitarRepetidos(){
        ArrayList<Object> nueva = new ArrayList<>();
        Object current;
        boolean repetido;
        for(int i = 0; i < this.elementos.size(); i++){
            repetido =  false;
            current = this.elementos.get(i);
            for(int j = 0; j < nueva.size(); j++){
                if(current.equals(nueva.get(j))){
                    repetido = true;
                    break;
                }
            }
            if(!repetido)
                    nueva.add(current);
        }
        this.elementos = nueva;

    }
}