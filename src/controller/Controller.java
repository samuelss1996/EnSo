package controller;

import importModule.CSVImport;
import importModule.IImport;
import model.DataAccess;
import model.IDataAccess;
import statistics.IStatistics;
import statistics.Statistics;

import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class Controller implements IController {

	public static void main(String[] args) throws DataFormatException, IOException {

	    Controller c = new Controller();
	    IImport importModule =c.getImportModule();
	    importModule.doImport(new int[]{1, 2, 3});
    }

	@Override
	public IImport getImportModule() {
		return  new CSVImport("src/importModule/pruebas.txt");
	}

	@Override
	public IDataAccess getDataAccessModule() {
		return new DataAccess();
	}

	@Override
	public IStatistics getStatisticsModule() {
		return new Statistics();
	}
}
