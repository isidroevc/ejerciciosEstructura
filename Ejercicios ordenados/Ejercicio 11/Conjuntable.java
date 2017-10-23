/**
    Instituto Tecnológico de León.
    Ingenieria En Sistemas Computacionales.
    Estructura de datos.
    Maestro: Ing. Cirino Silva Tovar.
    Alumno Vásquez Cortés Isidro Emmanuel
    Ejercicio 11.
    Fecha de elaboración 22/10/2017
 */
public interface Conjuntable {
    public Conjunto union (Conjunto c);
    public Conjunto diferencia(Conjunto c);
    public Conjunto interseccion(Conjunto c);
    public Conjunto diferenciaSimetrica(Conjunto c);
}