package controller;

import com.sun.xml.internal.bind.v2.model.core.ID;
import importModule.CSVImport;
import importModule.IImport;
import model.*;
import model.data.Product;
import model.data.Sell;
import model.data.SellLine;
import model.data.User;
import statistics.IStatistics;
import statistics.Statistics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Controller implements IController {

    public static void main(String[] args) throws DataFormatException, IOException {


        IDAOUser idaoUser = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getUserDAO();
        idaoUser.deregisterUser("U-AAAAA-001", "");
        idaoUser.fetchUser("U-AAAAA-000");
        idaoUser.getApplications("U-AAAAA-000");
        idaoUser.updateUser(new User("U-AAAAA-000", 1, "Nombre1", "Apellido",
                new Date(LocalDate.now().minusDays(2).toEpochDay()), "NIF12312", "", "E"));
        idaoUser.addUser(new User("U-AAAAA-001", 1, "Usuario2", "Apellid2",
                new Date(LocalDate.now().minusDays(2).toEpochDay()), "N1F12312", "", "E"));
        idaoUser.getCenter(1);
        idaoUser.queryUser("Nombre1");


        IDAOProduct idaoProduct = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getProductDAO();
        idaoProduct.addProduct(new Product("I-AAAAA-003", "Producto", 2, true,
                new Date(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond()), "categoria",
                "Este es un producto", 17.99f));
        idaoProduct.fetchProduct("I-AAAAA-003");
        idaoProduct.queryProduct("Producto");
        idaoProduct.queryStock("I-AAAAA-003");
        idaoProduct.updateAvailability(new Product("I-AAAAA-003", "Producto", 2, false,
                new Date(LocalDate.now().toEpochDay()), "categoria", "Este es un producto", 17.99f));
        idaoProduct.updateProduct(new Product("I-AAAAA-003", "Producto", 2, true,
                new Date(LocalDate.now().minusDays(1).toEpochDay()), "categoria", "Este es un producto",
                17.99f));

        IDAOSell idaoSell = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();
        Sell sell=new Sell("V-AAAAA-003", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "U-AAAAA-000", 248.97f);
        sell.addLine(new SellLine(new Product("I-AAAAA-000","Producto1",100,true,new Date(),
                "","",99.99f),2,99.99f));
        sell.addLine(new SellLine(new Product("I-AAAAA-001","Producto2",100,true,new Date(),
                "","",49.99f),1,49.99f));
        idaoSell.addSell(sell);
        idaoSell.querySell("V-AAAAA-003");

        Controller c = new Controller();

        IStatistics statistics = c.getStatisticsModule();
        statistics.calculateLastMonthDailyAverageSells(); //TODO revisar: da -1.3969839E-9, que supongo que es cercano al cero absoluto, pero bueno, quien lo hiciera que lo revise
        statistics.calculateLastMonthDailySellCount();
        statistics.calculateLastMonthSellCount();
        statistics.calculateLastWeekDailyRelativeSells();
        statistics.calculateLastWeekSellCount();
        statistics.calculateLastYearWeeklySellCount();
        statistics.calculateLastYearSellCount();
        statistics.calculateLastYearWeeklyAverageSells(); //TODO Mismo caso que calculateLastMonthDailyAverageSells
        statistics.calculateLastYearWeeklyRelativeSells();


        IImport importModule = c.getImportModule();
        importModule.doImport(new int[]{1, 2, 3});
        ImportData importData = importModule.doImport(new Date(LocalDate.now().minusYears(1).toEpochDay()), new int[]{1, 2, 3});
        //for (User u : importData.getUsers())
        //	idaoUser.addUser(u);
        for (Product p : importData.getProducts())
            idaoProduct.addProduct(p);
        for(Sell s : importData.getSells())
            idaoSell.addSell(s);
    }

    @Override
    public IImport getImportModule() {
        return new CSVImport("src/importModule/pruebas.txt");
    }

    @Override
    public IStatistics getStatisticsModule() {
        return new Statistics();
    }


}
