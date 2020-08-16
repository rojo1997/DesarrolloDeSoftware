#include "Tarjeta.h"
#include "VisitanteEquipo.h"

Tarjeta::Tarjeta(string name, float precio) : ComponenteEquipo(name, precio) {}
		
void Tarjeta::aceptar(VisitanteEquipo & v) {
	v.visitarTarjeta(*this);
}
