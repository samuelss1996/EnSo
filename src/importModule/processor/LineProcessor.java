package importModule.processor;

import model.ImportData;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * Generic class for processing a line present in a file which is being imported
 * @author Samuel Soutullo
 */
public abstract class LineProcessor {
	private final String line;
    private final String[] fields;
    private final Date minDate;

    /**
     * @param line The line that is going to be processed
     * @param minDate Minimum date for the line to be processed
     * @throws DataFormatException If the line itself or any field has wrong format
     */
    public LineProcessor(String line, Date minDate) throws DataFormatException {
        this.line = line;
        this.fields = Arrays.stream(line.split(";")).map(String::trim).toArray(String[]::new);
        this.minDate = minDate;

        this.checkLine(line);
    }

    /**
     * Instantiates a the proper line processor for a line
     * @param line The line
     * @param minDate Minimum date for the line to be processed
     * @return The line processor
     * @throws DataFormatException If the line type is not valid
     */
    public static LineProcessor createLineProcessorFor(String line, Date minDate) throws DataFormatException {
        switch (line.trim().charAt(0)) {
            case 'U':
                return new UserLineProcessor(line, minDate);
            case 'I':
                return new ProductLineProcessor(line, minDate);
            case 'V':
                return new SellLineProcessor(line, minDate);
            default:
                throw new DataFormatException(String.format("Invalid line type for line %s", line));
        }
    }

    /**
     * Checks if the line should be processed based on the minDate parameter and the date of the line itself
     * @param date The date of the line
     * @return True if the line should be processed
     */
    protected boolean shouldBeImportedBasedOnDate(Date date) {
        return this.minDate == null || this.minDate.compareTo(date) <= 0;
    }

    /**
     * Checks if the line has the correct field number and if all the fields are non-empty
     * @param line The line
     * @throws DataFormatException If the line has not the correct field number is any of the fields is empty
     */
    private void checkLine(String line) throws DataFormatException {
        if(this.getExpectedFieldCount() == this.fields.length) {
            throw new DataFormatException(String.format("Invalid field count. Expected %d. Found %d. Line: %s",
                    this.getExpectedFieldCount(), this.fields.length, line));
        }

        for(int i = 0; i < this.fields.length; i++) {
            if(this.fields[i].isEmpty()) {
                throw new DataFormatException(String.format("Field must not be empty. Field index : %d, line :%s", i, line));
            }
        }
    }

    public String getField(int index) {
        return this.fields[index];
    }

    public String getLine() {
        return this.line;
    }

    /**
     * Processes the line. Modifies the data parameter adding the data present in the line
     * @param data The ImportData object
     * @throws DataFormatException If the line itself or any field has wrong format
     */
    public abstract void processLine(ImportData data) throws DataFormatException;

    /**
     * @return The line type. It's one of the constants defined in the IImport interface
     */
	public abstract int getLineType();

    /**
     * @return The expected field count for the concrete line type
     */
	protected abstract int getExpectedFieldCount();
}
