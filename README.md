#Nombre del Proyecto
demo

#Tecnologías 
Spring Boot 
Spring Security 
Swagger2 3.0.0
JavaSE 1.8
Junit 3.8.1

#Descripción del Proyecto 

esta aplicación contiene dos endpoints que consumen una API de acceso público, a los cuales se puede acceder mediante una URL, contiene un nivel de seguridad básico donde le solicita al usuario credenciales para accedera dichos endpoints. Además se documentó toda la API para comprender su funcionamiento de mejor modo. Todo el tráfico realizao en la demo se documenta en log. 

#Características del Proyecto 
1. Login - Spring Security 

Usando la tecnología de spring-security se diseño un login con seguridad básica donde con las credenciales de un usuario puedes accerder a los endpoints de la aplicación, no se puede acceder directamente a niguno de los endpoint de aplicación sin estos usuarios. Luego que valida el acceso muestra un mensaje con el rol ingresado. Posteriormente a esto puede ingresar a los endpoinst de la app. 

Las ubicaciones de las clases son package com.login.flock.demo.security
                                  package com.login.flock.demo.controller.welcomePage  

2. API 

Se deserializo la respuesta de la API de acceso público https://apis.datos.gob.ar/georef/api/provincias, consumiendo esta API se codificaron dos endpoints para: 

    **Obtener todas Pronvicias, devuelve un objeto (DataJs.class) con todas las provincias de la Api.
    
    **Obtener el Centroide (Latitud y Longitud) de una provincia por su nombre, devuelve un objeto (Centroide.class) con la latitud y longitud de la provincia que se le pasa como parámetro  

    La ubicación de la clase es package com.login.flock.demo.controller.java

3. Documentaión de API

Se hizo uso del framework swagger para documentar la API, es decir a traves de una URL se puede acceder a la información  de documentación de la API, métodos del controller, además se puede probar los endpoints y ver su comportamiento. 

4. Pruebas Unitarias 

Utilizando la dependencia de springboot-test- junit y la librería mokito se codificaron dos métodos los cuales prueban el comportamiento de los endpoints: 
   
    **Obtener todas Pronvicias, usando la librería Mockito se simuló un objeto de tipo DataJa.class 
    caparandolo con la respuesta que trae el endpoint real. 

  **Obtener el Centroide, de la misma forma que para consultar una sola provincia, se creó un 
  objeto de tipo centroide con un nombre de provincia específico, luego se envió ese mismo 
  nombre al endopoint y con un assertequals se compararon si los objetos (Centroide.class) 
  eran iguales. 

  Ubicación package com.login.flock.demo;

5. Trace de Aplicación 

Utilizando el framework Logger se creó un objeto de este tipo y se trazaron logs en todos los endpoints con el motivo de tener un tracking de ejecución de la app. 

El log se alamcena en el root raiz del proyecto: logs/app.log
El archivo .xml de configuración del log se encuenta en src/main/resources/logback.xml

Cada ejecución será almacenada con los diferentes mensajes codificados en el método.

#Ejecutando la Aplicación 

1. Puerto  
El puerto  por defecto donde se ejecutan la demo es el port:8080 

En caso de que el puerto este ocupado 
netstat -ano | findstr :PORT_NUMBER

para terminar el proceso 
taskkill /PID PID /F

2. Login y Mensaje de usuario 
    2.1 Acceder a
        URL http://localhost:8080/login

    2.2 Logueo  
         Usuarios 
            username: user password:1234.user 
            username: admin password:1234.admin

        Al introducir las credencias debe mostrar el mensaje con el rol del usuario logueado, a partir de 
        este punto puede consultar cualquiera de los endpoints disponibles. 

3. Obtener una lista de provincias 

    3.1 Opción #1 
        A. seguir los pasos del apartado #Ejecutando Aplicación Sección 2 hasta el paso 2.2 
        
        B. Acceder a 
            http://localhost:8080/provincia 
    
        Devuelve la lista de provincias de la API publica 

    3.2 Opción #2 
        
        A. Acceder a 
            http://localhost:8080/provincia 
        B. loguearse con las credencias detalladas en 2.2 Logue Sección 2 de #Ejecutando Aplicación 

        Cada ejecución de los endpoints se irá grabando en el logger. 

4. Obtener un Centroide a Partir de un Nombre de pronvicia 

    4.1 Opción #1 
    
        A. Seguir los pasos del apartado #Ejecutando Aplicación Sección 2 hasta el paso 2.2 
        
        B. Acceder a 
            http://localhost:8080/provincias/centroide/{provinceName}
        
        provinceName: debe asignar el como valor alguna de las provincias de esta URL https://apis.datos.gob.ar/georef/api/provincias
    
        Devuelve el Centroide (Latitud, Longitud) de la provincia enviada en el GET. 

    4.2 Opción #2
        
        A.Acceder a 
            http://localhost:8080/provincias/centroide/{provinceName}
        
        provinceName: debe asignar el como valor alguna de las provincias de esta URL https://apis.datos.gob.ar/georef/api/provincias

        B. seguir los pasos del apartado #Ejecutando Aplicación Sección 2 hasta el paso 2.2 

          Devuelve el Centroide (Latitud, Longitud) de la provincia enviada en el GET.

5. Información de la API

    para consultar la aplicación de la API hacer lo siguiente:
    
    5.1 Acceder al entorno gráfico de swagger 
        http://localhost:8080/swagger-ui.html

    5.2 Loguearse 
    seguir los pasos del apartado #Ejecutando Aplicación Sección 2 hasta el paso 2.2

    permite navegar en el entorno y ver información documentada de la API

6. Log de Aplicación 

    seguir los siguientes pasos 
    
    A.detener la aplicación 
    
    B. ir al siguiente directorio logs/app.log de la apliación 
    
    C. hace doble click en el archivo y ver el trace del log de la aplicación  
