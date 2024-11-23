# Crear una Base de Datos en MySQL

## Paso 1: Crear la Base de Datos

Crea una base de datos en MySQL utilizando el puerto **3066** con el nombre `ecommerce`. Puedes usar el siguiente comando:

```sql
CREATE DATABASE ecommerce;
```
## Paso 2: Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3066/ecommerce
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
```
Reemplaza *TU_USUARIO* y *TU_CONTRASEÑA* con las credenciales correspondientes de tu base de datos.

## Paso 3: Editor Recomendado
Inserta al menos un registro en la tabla *usuarios* utilizando el siguiente comando SQL:
```sql
INSERT INTO usuarios (direccion,email ,nombre,password,telefono,tipo,username) values ("admin","admin","admin","adminadmin123","admin","admin","admin");
```
