# Casos de prueba para E-01
Dado que realizando todos los casos de prueba teniendo en cuenta las distintas entradas y métodos de la interfaz serían 16 casos, se ha decido probar 1 entrada por método. La entrada incorrecta se probará en el método que calcula los valores brutos de ventas debido a su sencillez (es una consulta directa a un elemento de la BBDD sin la realización de ningún tipo de operación).

# Caso de prueba E-01-P-01
## Dependencias
Valida la consulta de ventas totales diarias.
## Definición
|Modo|
|--|
|-3|
## Resultado esperado
El resultado será un mensaje de error indicando que se ha realizado la consulta de manera incorrecta (se ha introducido un modo erróneo). 

# Caso de prueba E-01-P-02
## Dependencias
Valida la consulta de la media de ventas semanales.
## Definición
|Modo|
|--|
|2|
## Resultado esperado
El resultado será la media de ventas semanales.


# Caso de prueba E-01-P-03
## Dependencias
Valida la consulta del histograma de ventas mensuales
## Definición
|Modo|
|--|
|3|
## Resultado esperado
El resultado será el histograma de ventas mensuales.

# Caso de prueba E-01-P-04
## Dependencias
Valida la consulta de los porcentajes de las ventas diarias.
## Definición
|Modo|
|--|
|1|
## Resultado esperado
El resultado será el porcentaje correspondiente a las ventas diarias.
