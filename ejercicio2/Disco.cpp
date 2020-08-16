#include "Disco.h"
#include "VisitanteEquipo.h"

Disco::Disco(string name, float precio) : ComponenteEquipo(name, precio) {

}
		
void Disco::aceptar(VisitanteEquipo & v) {
	v.visitarDisco(*this);
}
