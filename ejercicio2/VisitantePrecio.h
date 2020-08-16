#ifndef VISITANTE_PRECIO
#define VISITANTE_PRECIO

#include <iostream>

#include "VisitanteEquipo.h"

class VisitantePrecio : public VisitanteEquipo {
	private:
		float coste_total = 0.0;
		
	public:
		void visitarDisco(Disco d);
			
		void visitarTarjeta(Tarjeta t);
		
		void visitarBus(Bus b);
		
		void show(void);
};

#endif
