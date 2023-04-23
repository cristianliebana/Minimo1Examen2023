PRIMER COMMIT DEL EXAMEN 20/04/2023:

-Interfaz hecha.
-De la implementación faltan: String getEstadoActual(String idUsuario); //Consulta el estado del juego

    Juego restarVidas(String idjuego, int restavidas); //Actualización del valor de vida de un usuario

    List<Juego> getVidasUsauario(String idUsuario); //Consulta de la vida de un usuario

    List<Juego> getVidaEquipo(String nombreEquipo); //Consulta de la suma de la vida de todos los usuarios de un equipo

-Se ha inicializado los parametros del addUsuario y addObjeto en el test y se ha planteado el test del realizarCompra.
-Fachada implementada como un Singleton.
-En los metodos que hay escritos se ha aplicado log4j.
-A modo de intentar hacer algo de la parte dos se han hecho los posts de añadir un usuario y un objeto y se ha 
añadido tambien el Post de comprar un objeto.

En general ha sido un caos y me he liado muchisimo pero estoy convencido de que si replanteo el ejercicio de cero, para el siguiente commit estará todo implementado.

SEGUNDO COMMIT EN CASA 23/04/2023

Despues de estar 3 dias comiendome la cabeza con este exámen y durmiendo poco dado que los fines de semana trabajo haciendo extras de camarero en un restaurante en la playa y he tenido que aprovechar 
las noches hasta las tantas, esto es lo que he conseguido hacer:

-Exámen replanteado desde cero, todas las clases y metodos son nuevos.
-Interfaz hecha con todos los metodos y con metodos auxiliares.
-Implementación con todos los metodos funcionales exceptuando el momento de reconducir a cada jugador a un equipo distinto, solo he logrado que ambos jugadores se unan al mismo equipo.
-Fachada implemetanda como un Singleton.
-Todos los metodos tienen incorporados loggers (log4j).
-He hecho los tests de todos los metodos exceptuando los auxiliares y exceptuando el test de iniciarpartida que como bien he dicho antes asigna a todos al mismo equipo, todos dan cosas con mas o menos sentido.
-De la segunda parte está todo completo y se ha comprobado ejecutando el "main" que los Puts,post y gets estan en el swagger.

Independientemente de la nota que vaya a sacar estoy contento con que al menos para esta segunda versión haya conseguido entregar algo que a pesar de tener errores,
tenga un cierto sentido dado que mi entrega del jueves fue algo bastante lamentable xd.