#include "VisitantePrecioDetalle.h"
#include "Disco.h"
#include "Tarjeta.h"
#include "Bus.h"
#include <utility>
#include <iostream>

void VisitantePrecioDetalle::visitarDisco(Disco d) {
	this->lista_precio.push_back(make_pair(d.getName(),d.getPrecio()));
}
		
void VisitantePrecioDetalle::visitarTarjeta(Tarjeta t) {
	this->lista_precio.push_back(make_pair(t.getName(),t.getPrecio()));
}

void VisitantePrecioDetalle::visitarBus(Bus b) {
	this->lista_precio.push_back(make_pair(b.getName(),b.getPrecio()));
}

void VisitantePrecioDetalle::show(void) {
	cout << "Tabla de precios: " << this->lista_precio.size() << "\n";
	for (list<pair<string,float> >::iterator it = this->lista_precio.begin(); it != this->lista_precio.end(); it++){
		cout << it->first << " : " << it->second << "\n" ;
	}
}
