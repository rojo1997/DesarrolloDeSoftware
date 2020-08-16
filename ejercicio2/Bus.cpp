#include "Bus.h"
#include "VisitanteEquipo.h"

Bus::Bus(string name, float precio) : ComponenteEquipo(name, precio) {}

void Bus::aceptar(VisitanteEquipo & v) {
	v.visitarBus(*this);
}
