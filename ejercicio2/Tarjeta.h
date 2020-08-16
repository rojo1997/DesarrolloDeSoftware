#ifndef TARJETA
#define TARJETA

#include <string>

#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

using namespace std;

class Tarjeta: public ComponenteEquipo {
	public:
		Tarjeta(string name, float precio);
		
		void aceptar(VisitanteEquipo & v);
};

#endif
