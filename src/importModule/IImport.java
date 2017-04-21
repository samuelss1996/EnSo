package importModule;

import model.ImportData;

import java.util.Date;

public interface IImport {
	int USER_ELEMENTS = 1;
	int ITEM_ELEMENTS = 2;
	int SELL_ELEMENTS = 3;
	ImportData importModule(int[] elements);
	ImportData importModule(Date dateFrom, int[] elements);
}
