#ifndef VISITANTE_PRECIO_DETALLE
#define VISITANTE_PRECIO_DETALLE

#include <list>
#include <string>
#include <utility>
#include <iostream>

#include "VisitanteEquipo.h"

using namespace std;

class VisitantePrecioDetalle : public VisitanteEquipo {
	private:
		list<pair<string,float> > lista_precio;
	
	public:
		void visitarDisco(Disco d);
				
		void visitarTarjeta(Tarjeta t);
		
		void visitarBus(Bus b);
		
		void show(void);
};

#endif
