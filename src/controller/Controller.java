package controller;

import importModule.IImport;
import model.IDataAccess;
import statistics.IStatistics;

public class Controller implements IController {

	public static void main(String[] args) {

	}

	@Override
	public IImport getImportModule() {
		return null;
	}

	@Override
	public IDataAccess getDataAccessModule() {
		return null;
	}

	@Override
	public IStatistics getStatisticsModule() {
		return null;
	}
}
