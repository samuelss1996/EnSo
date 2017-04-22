package importModule;

import model.data.ImportData;

import java.io.IOException;
import java.util.Date;
import java.util.zip.DataFormatException;

public interface IImport {
	int USER_ELEMENTS = 1;
	int ITEM_ELEMENTS = 2;
	int SELL_ELEMENTS = 3;

    /**
     * Imports users, items and/or sells from a file
     * @param elements Specifies the type of elements that should be imported. Must be one or more of the constants
     *                 defined in IImport
     * @return ImportData object that contains the encapsulated data read from the file
     * @throws DataFormatException If any data in the file has wrong format
     * @throws IOException If file does not exist or any IO error occurs while reading the file
     */
	ImportData doImport(int[] elements) throws DataFormatException, IOException;

    /**
     * Imports users, items and/or sells from a file if their date of register, availability or sell is equal is the
     * same or more recent than a specified date
     * @param dateFrom Specifies the date described above
     * @param elements Specifies the type of elements that should be imported. Must be one or more of the constants
     *                 defined in IImport
     * @return ImportData object that contains the encapsulated data read from the file
     * @throws DataFormatException If any data in the file has wrong format
     * @throws IOException If file does not exist or any IO error occurs while reading the file
     */
	ImportData doImport(Date dateFrom, int[] elements) throws DataFormatException, IOException;
}
