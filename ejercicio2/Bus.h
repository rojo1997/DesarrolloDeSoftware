#ifndef BUS
#define BUS

#include <string>

#include "Bus.h"
#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

using namespace std;

class Bus: public ComponenteEquipo {
	public:
		Bus(string name, float precio);
		
		void aceptar(VisitanteEquipo & v);
};

#endif
