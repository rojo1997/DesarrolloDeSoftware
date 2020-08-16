#ifndef VISITANTE_EQUIPO
#define VISITANTE_EQUIPO

class Disco;
class Tarjeta;
class Bus;

class VisitanteEquipo {
	public:
		virtual void visitarDisco(Disco d);
		
		virtual void visitarTarjeta(Tarjeta t);
		
		virtual void visitarBus(Bus b);
		
		virtual void show(void);
};

#endif
