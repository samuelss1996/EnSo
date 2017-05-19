import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import DAO.DAOModuleInsertOrderTest;
import DAO.DAOModuleInsertTest;
import DAO.DAOModuleOrderValidationTest;
import DAO.DAOModuleReadTest;
import DAO.DAOModuleUpdateTest;
import imports.ImportsModuleDependentsTest;
import imports.ImportsModuleTest;
import statistics.StatisticsModuleDBWithPurchaseTest;
import statistics.StatisticsModuleEmptyDBTest;
import statistics.StatisticsModuleFinalTest;
import statistics.StatisticsModuleTest;

@RunWith(Suite.class)
@SuiteClasses({StatisticsModuleEmptyDBTest.class, StatisticsModuleDBWithPurchaseTest.class, StatisticsModuleTest.class, StatisticsModuleFinalTest.class, DAOModuleInsertTest.class, DAOModuleInsertOrderTest.class, ImportsModuleTest.class, ImportsModuleDependentsTest.class, 
	DAOModuleOrderValidationTest.class, DAOModuleUpdateTest.class, DAOModuleReadTest.class})
public class AllTests {}