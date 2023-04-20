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