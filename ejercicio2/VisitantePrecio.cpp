#include "VisitantePrecio.h"
#include "Disco.h"
#include "Tarjeta.h"
#include "Bus.h"
#include <iostream>

void VisitantePrecio::visitarDisco(Disco d) {
	this->coste_total += d.getPrecio();
}
		
void VisitantePrecio::visitarTarjeta(Tarjeta t) {
	this->coste_total += t.getPrecio();
}

void VisitantePrecio::visitarBus(Bus b) {
	this->coste_total += b.getPrecio();
}

void VisitantePrecio::show(void) {
	cout << "coste total: " << this->coste_total << "\n";
}
