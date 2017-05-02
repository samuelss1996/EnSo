# Método `importarCompra(String path)`
## Código
```java
public int importarCompra(String path) {
    FileInputStream archivo;
    BufferedReader lectura = null;
    String linha;
    String[] partes;
    int numero = 0;

    try {
        archivo = new FileInputStream(path);
        lectura = new BufferedReader(new InputStreamReader(archivo));
    } catch (FileNotFoundException e) {
        System.out.println("Exception en ImportsModule.java ImportarCompra en lectura del archivo: " + e);
        return -1;
    }

    try {
        while ((linha = lectura.readLine()) != null) {
            partes = linha.split(";");
            for (int i = 0; i < partes.length; i++) {
                partes[i] = partes[i].replaceAll("\\s+", "");
            }

            if (partes[0].equals("V") && partes[1].length() == 11 && partes[2].length() == 10 && partes[3].length() == 11 && partes[4].length() == 11 && !partes[5].isEmpty() && !partes[6].isEmpty()) {
                User user = this.userDAO.isRegistered(partes[3]);

                Order order = new Order(Integer.valueOf(partes[1]), user);
                Item item = this.itemDAO.getItemById(partes[4]);
                Line line = new Line(Integer.valueOf(partes[5]), Integer.valueOf(partes[6]), item);

                order.addLine(line);

                this.purchaseDAO.insertOrder(order);
                numero++;
            }
        }
        lectura.close();

    } catch (IOException ioe) {
        System.out.println("Excepcion en lectura de linea en ImportsModule.java Importar compra na lectura do archivo:" + ioe);
    }


    return numero;
} 
```

## Definición de nodos
* 0: sentencias previas al primer `try`
* 1: sentencias dentro del primer `try`
* 2: sentencias dentro del `catch(FileNotFoundException e)`
* 3: condición del bucle `while`
* 4: primera sentencia dentro del bucle `while`
* 5: condición del bucle `for`
* 6: sentencia dentro del bucle `for`
* 7: primera condición del `if`
* 8: segunda condición del `if`
* 9: tercera condición del `if`
* 10: cuarta condición del `if`
* 11: quinta condición del `if`
* 12: sexta condición del `if`
* 13: séptima condición del `if`
* 14: sentencias dentro del `if`
* 15: sentencia `lectura.close();`
* 16: sentencias dentro del `catch(IOException ioe)`
* 17: sentencia `return numero;`

## Complejidad ciclomática
V(G) = a - n + 2 = 27 - 18 + 2 = 11

## Selección de caminos
* Camino 1: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 13 - 14 - 3 - 15 - 17
	* Camino del caso base. Se lee un archivo con una línea.
* Camino 2: 0 - 1 - 2
	* Se lanza una excepción porque el archivo no existe
* Camino 3: 0 - 1 - 3 - 16 - 17
	* Se lanza una excepción porque se produce un error de E/S al leer una línea del archivo
* Camino 4: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 13 - 14 - 3 - 15 - 16 - 17
	* Se lanza una excepción porque se produce un error de E/S al cerrar el `BufferedReader`
* Camino 5: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 3 - 15 - 17
	* El `if` falla en la primera condición
* Camino 6: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 3 - 15 - 17
	* El `if` falla en la segunda condición
* Camino 7: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 3 - 15 - 17
	* El `if` falla en la tercera condición
* Camino 8: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 3 - 15 - 17
	* El `if` falla en la cuarta condición
* Camino 9: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 3 - 15 - 17
	* El `if` falla en la quinta condición
* Camino 10: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 3 - 15 - 17
	* El `if` falla en la sexta condición
* Camino 11: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 13 - 3 - 15 - 17
	* El `if` falla en la séptima condición

## Definición de casos de prueba
* Camino 1:
    * Prerrequisitos: 
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El usuario `U-AAAAA-000` existe en la base de datos
        * El ítem `I-AAAAA-000` existe en la base de datos
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 10/10/2010; U-AAAAA-000; I-AAAAA-000; 1; 10`
    * Entrada: 
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `1` y la compra se importa
* Camino 2:
    * Prerrequisitos:
        * No existe el fichero `sells.csv`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `-1`
* Camino 3:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * No se tienen permisos de lectura sobre el fichero `sells.csv`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y se imprime por pantalla un mensaje de error.
* Camino 4:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se bloqueará el fichero `sells.csv` justo antes de que se ejecute la línea `lectura.close();`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y se imprime por pantalla un mensaje de error.
* Camino 5:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `A; V-AAAAA-000; 10/10/2010; U-AAAAA-000; I-AAAAA-000; 1; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 6:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-00; 10/10/2010; U-AAAAA-000; I-AAAAA-000; 1; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 7:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 3/10/2010; U-AAAAA-000; I-AAAAA-000; 1; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 8:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 10/10/2010; U-AAAAA-00; I-AAAAA-000; 1; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 9:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 10/10/2010; U-AAAAA-000; I-AAAAA-00; 1; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 10:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 10/10/2010; U-AAAAA-000; I-AAAAA-000;; 10`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos
* Camino 11:
    * Prerrequisitos:
        * Existe el fichero `sells.csv`
        * Se tienen permisos de lectura sobre el fichero `sells.csv`
        * El fichero contiene la siguiente línea: `V; V-AAAAA-000; 10/10/2010; U-AAAAA-000; I-AAAAA-000; 1;`
    * Entrada:
        * `path`: `"sells.csv"`
    * Salida esperada: El método devuelve `0` y no se realiza ningún cambio en la base de datos