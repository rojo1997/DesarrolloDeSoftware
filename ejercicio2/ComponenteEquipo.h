#ifndef COMPONENTE_EQUIPO
#define COMPONENTE_EQUIPO

#include <list>
#include <string>

#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

using namespace std;

class ComponenteEquipo {
	private:
		string name;
		float precio;
	
	public:
		ComponenteEquipo(string name, float precio);
		
		virtual float getPrecio(void);
		
		virtual string getName(void);
		
		virtual void aceptar(VisitanteEquipo & v);
};

#endif
