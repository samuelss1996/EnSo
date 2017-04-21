package controller;


import importModule.IImport;
import model.IDataAccess;
import statistics.IStatistics;

public interface IController {
	IImport getImportModule();
	IDataAccess getDataAccessModule();
	IStatistics getStatisticsModule();
}
