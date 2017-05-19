package imports;

import DAO.ItemDAO;
import DAO.PurchaseDAO;
import DAO.UserDAO;
import model.Item;
import model.Line;
import model.Order;
import model.User;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ImportsModule implements ImportsInterface {
    private UserDAO userDAO;
    private ItemDAO itemDAO;
    private PurchaseDAO purchaseDAO;

    public ImportsModule(String sCHEMA, String dB_URL, String uSER, String pASS) {
        this.itemDAO = new ItemDAO(sCHEMA, dB_URL, uSER, pASS);
        this.userDAO = new UserDAO(sCHEMA, dB_URL, uSER, pASS);
        this.purchaseDAO = new PurchaseDAO(sCHEMA, dB_URL, uSER, pASS);
    }

    public static Date asDate(LocalDate localDate) {
        return (Date) Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

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
            System.out.println("Excepcion en lectura de li�a en ImportsModule.java Importar usuarios na lectura do archivo:" + ioe);
        }


        return numero;
    }

    public int importarProducto(String path) {
        FileInputStream archivo;
        BufferedReader lectura = null;
        String linha;
        String[] partes;
        int numero = 0;

        try {
            archivo = new FileInputStream(path);
            lectura = new BufferedReader(new InputStreamReader(archivo));
        } catch (FileNotFoundException e) {
            System.out.println("Exception en ImportsModule.java ImportarProducto en lectura del archivo: " + e);
            return -1;
        }
        try {
            while ((linha = lectura.readLine()) != null) {
                partes = linha.split(";");
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].replaceAll("\\s+", "");
                }
                if (partes[0].equals("I") && partes[1].length() == 11 && partes[2].length() == 10 && !partes[3].isEmpty() && !partes[4].isEmpty() && !partes[5].isEmpty() && !partes[6].isEmpty()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                    LocalDate date = LocalDate.parse(partes[2], formatter);
                    Date datec;
                    datec = asDate(date);

                    Item item = new Item(partes[1], partes[3], partes[6], partes[4], Integer.valueOf(partes[5]), datec);
                    itemDAO.insertItem(item);
                    numero++;
                }
            }
            lectura.close();

        } catch (IOException ioe) {
            System.out.println("Excepcion en lectura de li�a en ImportsModule.java Importar productos na lectura do archivo:" + ioe);
        }


        return numero;
    }

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
            System.out.println("Excepcion en lectura de li�a en ImportsModule.java Importar compra na lectura do archivo:" + ioe);
        }


        return numero;
    }
}