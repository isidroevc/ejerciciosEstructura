public interface Conjuntable {
	Conjunto union(Conjunto a, Conjunto b);
	Conjunto interseccion(Conjunto a, Conjunto b);
	Conjunto diferencia(Conjunto a, Conjunto b);
	Conjunto diferenciaSimetrica(Conjunto a, Conjunto b);
	Conjunto complemento(Conjunto universo, Conjunto a);
}
