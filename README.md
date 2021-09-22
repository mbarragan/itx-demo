# itx-demo

Rest Microservice for ITX.
See technical documentation (Json collection and Swagger yaml file) on the project root.

You can find the requested tests as described below in class `ItxDemoIntegrationTest.java`.

Other tests were implemented to cover 91% of code lines.

---------------------------------
# La prueba

En la base de datos de comercio electrónico de la compañía disponemos de la tabla
PRECIOS que refleja el precio final (pvp) y la tarifa que aplica un producto de una
cadena entre las fechas determinadas. A continuación, se muestra un ejemplo de la
tabla con los campos relevantes:

PRECIOS
-------
BRAND_ID START_DATE END_DATE PRICE_LIST PRODUCT_ID PRIORITY PRICE CURR
-------------------------------------------------- ---------------------------
----------------------- -------------------------------------------------- ---
----------------------------------------------- ------------------------------
----
1 2020-06-14-00.00.00 2020-12-31-23.59.59 1 35455 0 35.50 EUR
1 2020-06-14-15.00.00 2020-06-14-18.30.00 2 35455 1 25,45 EUR
1 2020-06-15-00.00.00 2020-06-15-11.00.00 3 35455 1 30,50 EUR
1 2020-06-15-16.00.00 2020-12-31-23.59.59 4 35455 1 38,95 EUR

Campos:

BRAND_ID: clave foránea de la cadena del grupo (1 = ZARA).
START_DATE, END_DATE: rango de fechas en el que aplica el precio tarifa indicada.
PRECIO_LISTA: Identificador de la tarifa aplicable.
PRODUCT_ID: Identificador código de producto.
PRIORIDAD: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un
rango de fechas se aplica la mayor de las fechas (mayor valor numérico).
PRECIO: precio final de venta.
CURR: iso de la moneda.

Se pide:

Construir una aplicación / servicio en SpringBoot que intenta un punto final resto de
consulta tal que:

 Acepte como parámetros de entrada: fecha de aplicación, identificador de
producto, identificador de cadena.
 Devuelva como datos de salida: identificador de producto, identificador de
cadena, tarifa a aplicar, intervalo de fechas en las que aplica el precio y precio
final a aplicar.
 Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los
datos del ejemplo, (se pueden cambiar el nombre de los campos y agregar
nuevos si se quiere, elegir el tipo de dato que se considera adecuado para los
mismos)

Desarrollar unos test al endpoint rest que validen las siguientes solicitudes al servicio
con los datos del ejemplo:

 Prueba 1: petición a las 10:00 del día 14 del producto 35455 para la marca 1
(ZARA)
 Prueba 2: petición a las 16:00 del día 14 del producto 35455 para la marca 1
(ZARA)
 Prueba 3: petición a las 21:00 del día 14 del producto 35455 para la marca 1
(ZARA)
 Prueba 4: petición a las 10:00 del día 15 del producto 35455 para la marca 1
(ZARA)
 Prueba 5: petición a las 21:00 del día 16 del producto 35455 para la marca 1
(ZARA)
