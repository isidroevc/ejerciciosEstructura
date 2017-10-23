/**
    Instituto Tecnológico de León.
    Ingenieria En Sistemas Computacionales.
    Estructura de datos.
    Maestro: Ing. Cirino Silva Tovar.
    Alumno Vásquez Cortés Isidro Emmanuel
    Ejercicio 10
    Fecha de elaboración 22/10/2017
 */
public interface Conjuntable {
	Conjunto union(Conjunto a, Conjunto b);
	Conjunto interseccion(Conjunto a, Conjunto b);
	Conjunto diferencia(Conjunto a, Conjunto b);
	Conjunto diferenciaSimetrica(Conjunto a, Conjunto b);
	Conjunto complemento(Conjunto universo, Conjunto a);
}
