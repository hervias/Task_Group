1 Task es una carpeta que contiene un Api Rest con todos los servicios solicitados.
	1.1 Fue construida en Maven, framework Spring Boot, y como lenguaje utilizo Java 8.
	

2 Instalación y configuración del entorno:
	2.1 Descargar SpringTool Suite 4, ya que esta posee las variables de entorno configuradas por defecto.

	2.2 Abrir Sring Tool Suite 4.

	2.3 Importar el proyecto que se encuentra dentro de la carpeta task.

	2.4 Si existiera algún error en la aplicación se debe a que no se descargaron correctamente las dependencias, por lo que procederemos a reinstalarlas y limpiar el entorno, damos click derecho encima de la raíz del proyecto, luego click en "Run as" --> "Maven install", al concluir con exito este procedimiento damos click encima de la raíz del proyecto, luego damos click en "Maven" --> "Update project..".

	2.5 Una vez se haya concluido la importación y no existan errores en el proyecto(error en la instalación de alguna dependencia) se deber iniciar el proyecto dando click encima de la raíz, luego click en "Run as" --> "Spring Boot App", una vez hecho este procedimiento desplegara una consola en donde nos indicara que la app se encuentra corriendo en el puerto 9099

3 Consideraciones:
	3.1 Al correr la aplicación no sé podra consumir ningún servicio a excepción del servicio que se encuentra en la ruta de collection llamado "Task_Group.postman_collection.json" Authenticate --> Authenticate el cual contiene unas llaves que son firmadas, encriptadas y luego devuelta en un formato string que tendrá que ser copiada y pegada en la cabecera "X-ignature" con el formato "xsignature su_llave_devuelta" de cada uno de los servicios solicitados.

