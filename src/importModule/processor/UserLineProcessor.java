package importModule.processor;

import importModule.IImport;
import model.ImportData;
import model.data.User;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class UserLineProcessor extends LineProcessor {

    public UserLineProcessor(String line, Date minDate) throws DataFormatException {
		super(line, minDate);
	}

	@Override
	public void processLine(ImportData data) throws DataFormatException {
        try {
            User user = new User();
            Date registerDate = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.forLanguageTag("es")).parse(this.getField(2));

            if (this.shouldBeImportedBasedOnDate(registerDate) && this.checkFieldsFormat()) {
                user.setId(this.getField(1));
                user.setRegisterDate(registerDate);
                user.setFirstName(this.getField(3));
                user.setLastName(this.getField(4));
                user.setNIF(this.getField(5));
                user.setTypeUser("E");

                data.addUser(user);
            }
        } catch (ParseException e) {
            throw new DataFormatException(String.format("Invalid date format. Expected dd/mm/aaaa. Found %s", this.getField(2)));
        }
    }

    /**
     * Checks if all the fields have the correct format for a user line
     * @return True if all the fields have the correct format
     * @throws DataFormatException If any of the fields has an invalid format
     */
    private boolean checkFieldsFormat() throws DataFormatException {
        if(!this.getField(1).matches("^U-[a-zA-Z]{6}-[0-9]{3}$")) {
            throw new DataFormatException(String.format("Invalid user identifier. Expected U-XXXXX-000. Found %s", this.getField(1)));
        } else if(!this.getField(5).matches("^[0-9]{8}[a-zA-Z]$")) {
            throw new DataFormatException(String.format("Invalid user NIF: %s", this.getField(5)));
        }

        return true;
    }

	@Override
	public int getLineType() {
		return IImport.USER_ELEMENTS;
	}

    @Override
    protected int getExpectedFieldCount() {
        return 6;
    }
}