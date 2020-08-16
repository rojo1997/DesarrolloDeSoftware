#include "ComponenteEquipo.h"

ComponenteEquipo::ComponenteEquipo(string name, float precio){
	this->name = name;
	this->precio = precio;
}

float ComponenteEquipo::getPrecio(void) {
	return this->precio;
}

string ComponenteEquipo::getName(void) {
	return this->name;
}

void ComponenteEquipo::aceptar(VisitanteEquipo & v) {
}
