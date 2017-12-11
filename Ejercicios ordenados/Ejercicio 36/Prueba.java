public class Prueba {
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        for(int i = 0; i < 10; i++){
            cola.insertar(Integer.toString(i));
        } 
        int i = 0;
        while(!cola.esVacia()) {
            i = cola.longitud() - 1;
            System.out.println(cola.toString());
            System.out.println("extraido: " + cola.frente());
            i++;
        }
    }
}