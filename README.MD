# Proyecto Spring Boot

Este es un proyecto de ejemplo utilizando Spring Boot. 
A continuación, encontrarás las instrucciones para configurar, construir y ejecutar el proyecto utilizando un perfil específico para QA (`application-qa.properties`).

## Prerrequisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- [Java Development Kit (JDK) 17+](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- [Apache Maven 3.6.0+](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/)
- [MySQL](https://dev.mysql.com/downloads/)

## Clonar el repositorio

Primero, clona el repositorio del proyecto a tu máquina local:

git clone https://github.com/pcorquidev/SGCyA.git
cd SGCyA

Configuración del Archivo de Propiedades
El proyecto está configurado para utilizar diferentes archivos de propiedades para distintos entornos. En este caso, utilizaremos application-qa.properties para el entorno de QA.

Construir el Proyecto
Para construir el proyecto y generar el archivo JAR utilizando el perfil de QA, sigue estos pasos:
1. Limpiar y construir el proyecto con Maven
   mvn clean install -Pqa
2. Verificar que el JAR se haya generado
   Después de ejecutar el comando anterior, el archivo JAR se generará en el directorio target. Puedes verificarlo con el siguiente comando:
   ls target/*.jar
3. Ejecutar la Aplicación
   Para ejecutar la aplicación utilizando el archivo JAR generado y el perfil de QA, utiliza el siguiente comando:
   java -jar target/tu-aplicacion.jar --spring.profiles.active=qa
