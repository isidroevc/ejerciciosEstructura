public class Prueba {
    public static void main(String[] args){
        Lista<String> l = new Lista<>();
        l.insertar("Hola mundo listas");
        l.insertar("Show me you war face");
        l.insertar("I'm gonna make you a fucking psycho");
        l.insertar("I'm the 3 index element");
        l.borrar(1);
        System.out.println(l.get(1));
        //System.out.println(l.get(0));
        System.out.println(l.localizar("I'm gonna make you a fucking psycho"));
        System.out.println(l.localizar("I'm the 3 index element"));
    }
}