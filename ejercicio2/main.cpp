#include <iostream>
#include <list>
#include "Disco.h"
#include "Tarjeta.h"
#include "Bus.h"
#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"
#include "VisitantePrecio.h"
#include "VisitantePrecioDetalle.h"


using namespace std;

int main(int argc, char** argv) {
	ComponenteEquipo *disco = new Disco("WD", (float) 60.40);
	ComponenteEquipo *tarjeta = new Tarjeta("NVIDIA", (float) 140.23);
	ComponenteEquipo *bus = new Tarjeta("FHJS", 3948.23);
	
	VisitanteEquipo *visitante_precio = new VisitantePrecio();
	VisitanteEquipo *visitante_precio_detalle = new VisitantePrecioDetalle();
	
	disco->aceptar(*visitante_precio);
	disco->aceptar(*visitante_precio_detalle);
	tarjeta->aceptar(*visitante_precio);
	tarjeta->aceptar(*visitante_precio_detalle);
	bus->aceptar(*visitante_precio);
	bus->aceptar(*visitante_precio_detalle);
	
	visitante_precio->show();
	visitante_precio_detalle->show();
	
	int out ;
	cin >> out;
	
	return 0;
}
