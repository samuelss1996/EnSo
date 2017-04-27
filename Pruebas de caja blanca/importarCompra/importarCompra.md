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