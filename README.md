# Productividad basada en herramientas tec Fase 3

## Descripcion del Proyecto
En nuestro trabajo, se nos pide llegar a una cantidad de casos por día, con casos, me refiero a clientes atendidos durante el día, por lo que tenemos que llegar a una meta diaria de aproximadamente 28 o 32 casos.
Aunque mi empresa ya cuenta con demasiados softwares para básicamente todo lo que hacen, aun nos falta un software que nos facilite ver la cantidad de casos que llevamos por día y si estamos cerca de nuestra meta o no, por así decirlo, seria una calculadora de CPH (Cases Per Hour).

La Aplicacion desarrollada es muy simple, es una calculadora local que nos permite hacer el calculo de forma instantanea, para despues poder poner ese resultado en nuestro tracker que tenemos que llenar de forma diaria en mi trabajo, esto hace que no tengamos que desperdiciar tiempo para realizar el calculo de forma manual y podemos obtener nuestro CPH en menos de 1 minuto sin necesidad de realizar formulas o calculos dentro de excel.

## Problema
La problemática que he observado en esto, es que debido a que siempre hacemos esto de forma manual, en hojas de Excel por ejemplo, a veces puede ser un poco tardado mantener un registro de todos los casos que hacemos durante el día mientras estamos atendiendo clientes, lo que hace que algunas veces no hagamos un registro correcto de nuestros casos y muchos de ellos no queden registrados, además, hacer el calculo de forma manual puede consumir algo de tiempo, por lo que tener un software ya configurado para hacer este calculo de forma automática, será mucho mas sencillo y tomara solo unos segundos de nuestro tiempo utilizarlo.

Adicionalmente, no todos los trabajadores conocen la formula para sacar el numero correcto de CPH, pues puede ser medio confusa lo que puede provocar que si alguien hace un calculo incorrecto, obtendra resultados incorrectos en los cuales se observara una discrepancia entre el CPH real y el CPH calculado.

## Solucion
La solución que propondrá este pequeño software es que será una aplicación la cual ya estará configurada para hacer un cálculo de forma automática sobre cual es nuestro porcentaje de CPH, haciendo que nos sea muy sencillo solamente poner los números de casos que llevamos y el software hará el cálculo de forma automática, mostrándonos nuestro actual porcentaje y lo mostrara de colores distintos dependiendo de si estamos cerca de la meta diaria o no.

Ademas, de esta forma, se evitara la perdida de tiempo al realizar calculos manuales y tambien las probabilidades de obtener un calculo incorrecto seran practicamente nulas, por lo cual, nos facilitara este proceso en un 100% al ser una aplicacion muy sencilla y simple de utilizar.

## Arquitectura
En esta seccion, realice un diagrama de la arquitectura de la aplicacion, y tambien un diagrama de flujo sobre como es su arquitectura durante su ejecucion.

![image](https://github.com/Yeims01/Fase3herramientastec/assets/157261329/50662845-1d56-47ea-9709-a0cfd49759ef)

## Tabla de Contenidos
- [Requerimientos](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#requerimientos)
- [Instalacion](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#instalacion)
- [Configuracion](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#configuracion)
- [Uso](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#uso)
- [Contribucion](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#contribucion)
- [Roadmap](https://github.com/Yeims01/Fase3herramientastec/develop/README.md#roadmap)

## Requerimientos
Para una ejecucion de la aplicacion, simplemente es necesario tener la version de Java mas reciente instalada, de esa forma, el programa podra ser ejecutado, no obstante, adjunto detalles adicionales:

- Java Development Kit (JDK) 8 o superior.
- Entorno de desarrollo IntelliJ IDEA o Eclipse.

## Instalacion

Para instalar el programa, solo se requiere descargar el archivo ZIP, el cual contiene todos los recursos necesarios para que la aplicacion pueda ejecutarse de forma local, puede descargarse desde la seccion de "Release" seleccionando la version de v1.1

Otra opcion de instalacion, puede ser la siguiente, aunque un poco mas compleja:

1. Clonar el repositorio en tu computadora utilizando el siguiente comando dentro de Git Bash o CMD: "git clone https://github.com/tu-usuario/Fase3herramientastec"
2. Una vez clonado, puedes abrirlo utilizando tu herramienta de desarrollo preferida, sin embargo, es recomendable que sea dentro de IntelliJ Idea o Eclipse IDE.

## Configuracion
No es necesaria algun tipo de configuracion para poder ejecutar la aplicacion.

## Uso
- Utilizando el ejecutable
  Simplemente tienes que abrir el ejecutable que se encuentra dentro del archivo zip, de esa forma, abriras la aplicacion y podras utilizarla.
  Proceso para utilizar:
  1. Inserta tu usuario y contraseña (**NOTA: Debido a que la autenticacion esta en fase experimental, por favor utiliza el usuario: Admin y la contraseña: 1234**)
  2. Llena los campos del CPH dependiendo de los casos realizados en las horas indicadas.
  3. Presiona el boton de "Calculate"
  4. Listo, obtendras los resultados de tu CPH, los cuales podras insertar en tu tracker de trabajo :)

- Ejecutandolo desde algun ambiente de desarrollo
  1. Abre el proyecto en tu ambiente de desarrollo.
  2. Compila y ejecuta la clase CPHCalculator para iniciar la aplicación.
  3. Ingresa el número de casos por hora en los campos proporcionados.
  4. Haz clic en el botón "Calculate" para obtener el promedio de casos por hora (CPH).

## Contribucion
Si deseas contribuir en este proyecto, tus contribuciones son bien recibidas, solo tienes que seguir los siguientes pasos:

1. Fork este repositorio.
2. Crea un nuevo branch para su funcionalidad: git checkout -b feature/nombre-funcionalidad.
3. Realiza los cambios necesarios y haz commit: git commit -m "Agregado la funcionalidad X".
4. Envía tus cambios al branch remoto: git push origin feature/nombre-funcionalidad.
5. Abre un pull request en GitHub y describe los cambios propuestos.

## Roadmap
Debido al poco tiempo y por motivos laborales, la aplicacion no esta al 100% completa, pero cumple con su objetivo principal, el cual es realizar el calculo del CPH de forma sencilla y rapida.
Sin embargo, aqui estan los planes a futuro para la aplicacion, ya que aun necesita muchas mejoras.

- Una mejor implementacion de seguridad y autenticacion de usuarios.
- Mejorar la interfaz de usuario para que tenga un estilo mas atractivo que mantenga un diseño facil de utilizar
- Integración con bases de datos para almacenar y recuperar datos de usuarios.
- Añadir funcionalidades de exportación de datos y generación de informes.
