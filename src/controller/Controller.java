package controller;

import importModule.IImport;
import model.IDataAccess;
import statistics.IStatistics;

public class Controller implements IController {

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
