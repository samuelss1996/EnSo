# Método `importarUsuarios(String path)`
## Código
```java
public int importarUsuarios(String path) {
    FileInputStream archivo;
    BufferedReader lectura = null;
    String linha;
    String[] partes;
    int numero = 0;

    try {
        archivo = new FileInputStream(path);
        lectura = new BufferedReader(new InputStreamReader(archivo));
    } catch (FileNotFoundException e) {
        System.out.println("Exception en ImportsModule.java ImportarUsuarios en lectura del archivo: " + e);
        return -1;
    }

    try {
        while ((linha = lectura.readLine()) != null) {
            partes = linha.split(";");
            for (int i = 0; i < partes.length; i++) {
                partes[i] = partes[i].replaceAll("\\s+", "");
            }
            if (partes[0].equals("U") && partes[1].length() == 11 && partes[2].length() == 10 && !partes[3].isEmpty() && !partes[4].isEmpty() && partes[5].length() == 9) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(partes[2], formatter);
                Date datec;
                datec = asDate(date);

                User user = new User(partes[1], partes[3], partes[4], partes[5], datec, User.ALUMN);
                userDAO.insertUser(user);
                numero++;
            }
        }
        lectura.close();

    } catch (IOException ioe) {
        System.out.println("Excepcion en lectura de linea en ImportsModule.java Importar usuarios na lectura do archivo:" + ioe);
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
* 13: sentencias dentro del `if`
* 14: sentencia `lectura.close();`
* 15: sentencias dentro del `catch(IOException ioe)`
* 16: sentencia `return numero;`

## Complejidad ciclomática
V(G) = a - n + 2 = 25 - 17 + 2 = 10

## Selección de caminos
* Camino 1: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 13 - 3 - 14 - 16
    * Camino del caso base. Se lee un archivo con una línea.
* Camino 2: 0 - 1 - 2
    * Se lanza una excepción porque el archivo no existe
* Camino 3: 0 - 1 - 3 - 15 - 16
    * Se lanza una excepción porque se produce un error de E/S al leer una línea del archivo
* Camino 4: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 13 - 3 - 14 - 15 - 16
    * Se lanza una excepción porque se produce un error de E/S al cerrar el `BufferedReader`
* Camino 5: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 3 - 14 - 16
    * El `if` falla en la primera condición
* Camino 6: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 3 - 14 - 16
    * El `if` falla en la segunda condición
* Camino 7: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 3 - 14 - 16
    * El `if` falla en la tercera condición
* Camino 8: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 3 - 14 - 16
    * El `if` falla en la cuarta condición
* Camino 9: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 3 - 14 - 16
    * El `if` falla en la quinta condición
* Camino 10: 0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11 - 12 - 3 - 14 - 16
    * El `if` falla en la sexta condición