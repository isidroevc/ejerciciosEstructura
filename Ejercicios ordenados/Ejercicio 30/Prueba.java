public class Prueba {

    public static void main(String[] args) {
        String prueba = "P,I,L,A";

        Pila<String> pila = new Pila<>(prueba.split(","));

        System.out.println(pila.toString());
        try { 
            System.out.println(pila.quitar());
            System.out.println("longitud: " + pila.longitud());
            pila.limpiar();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println(pila.toString());
        System.out.println("longitud: " + pila.longitud());
    }
}