#ifndef DISCO
#define DISCO

#include <string>

#include "Disco.h"
#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

using namespace std;

class Disco: public ComponenteEquipo {
	public:
		Disco(string name, float precio);
		
		void aceptar(VisitanteEquipo & v);
};

#endif
