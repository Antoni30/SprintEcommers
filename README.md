# Iniciar el proyecto

## Paso 1: Instalacion de IntelliJ IDEA ultimate
Instalamos el IDE que se ultilizara
Link: https://www.jetbrains.com/es-es/idea/download/?section=windows

## Paso 2: Abrir el proyecto usando el IDE
* Descargar el proyecto .zip o realizar un git clone del mismo
* Abrir el programa IntelliJ IDEA
* Selecionar open
* Abrir el proyecto desde la *Carpeta* del proyecto
* Si se pide autorizacion, colocar que si a todo esto solo es porque quiere realizar la instalacion de paquetes
* Si pide descargar JDK de java preferible hacerlo, asi ya dispoga de el

## Paso 3: Crear la Base de Datos

Crea una base de datos en MySQL utilizando el puerto **3306** con el nombre `ecommerce`. Puedes usar el siguiente comando:

```sql
CREATE DATABASE ecommerce;
```
## Paso 4: Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3066/ecommerce
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
```
Reemplaza *TU_USUARIO* y *TU_CONTRASEÑA* con las credenciales correspondientes de tu base de datos.

## Paso 5: Editor Recomendado
Inserta al menos un registro en la tabla *usuarios* utilizando el siguiente comando SQL:
```sql
INSERT INTO usuarios (direccion,email ,nombre,password,telefono,tipo,username) values ("admin","admin","admin","adminadmin123","admin","admin","admin");
```

## Paso 6: Correr el programa 
## Paso 7: Ingresar a: http://localhost:8080/administrador
