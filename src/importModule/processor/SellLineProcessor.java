package importModule.processor;


import importModule.IImport;
import model.ImportData;
import model.data.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class SellLineProcessor extends LineProcessor {

    public SellLineProcessor(String line, Date minDate) throws DataFormatException {
		super(line, minDate);
	}
    //TODO Si una linea de sell comprate id con otra, en lugar de crearse un nuevo sell debería añadirse la linea de compra
    //Ahora mismo el fichero no tiene ese caso, porque sino, no compila.
	@Override
    public void processLine(ImportData data) throws DataFormatException {
        try {
            Product sellProduct = new Product();
            Date sellDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.forLanguageTag("es")).parse(this.getField(2));

            if (this.shouldBeImportedBasedOnDate(sellDate) && this.checkFieldsFormat()) {
                //TODO: seria getField(2) porque no se tiene en cuenta el primer campo U-V-I;
                Sell sell = data.containsSell(this.getField(1))? data.getSellById(this.getField(1)) : new Sell();

                if (!data.containsSell(this.getField(1))) {
                    User sellUser = new User();

                    sell.setId(this.getField(1));
                    sell.setSellDate(sellDate);

                    sellUser.setId(this.getField(3));
                    sell.setUser(sellUser.getId());
                }

                sellProduct.setId(this.getField(4));
                sell.addLine(new SellLine(sellProduct, Integer.valueOf(this.getField(5)), Float.valueOf(this.getField(6))));

                data.addSell(sell);
            }
        } catch (ParseException e) {
            throw new DataFormatException(String.format("Invalid date format. Expected dd/mm/aaaa. Found %s", this.getField(2)));
        } catch (NumberFormatException e) {
            try {
                Integer.valueOf(this.getField(5));
            } catch (NumberFormatException e1) {
                throw new DataFormatException(String.format("Field must be an integer. Field index: %d. Line: %s", 5, this.getLine()));
            }

            try {
                Float.valueOf(this.getField(6));
            } catch (NumberFormatException e2) {
                throw new DataFormatException(String.format("Field must be a float. Field index: %d. Line: %s", 6, this.getLine()));
            }
        }
    }

    /**
     * Checks if all the fields have the correct format for a sell line
     * @return True if all the fields have the correct format
     * @throws DataFormatException If any of the fields has an invalid format
     */
    private boolean checkFieldsFormat() throws DataFormatException {
        if(!this.getField(1).matches("^V-[a-zA-Z]{5}-[0-9]{3}$")) {
            throw new DataFormatException(String.format("Invalid sell identifier. Expected V-XXXXX-000. Found %s", this.getField(1)));
        } else if(!this.getField(3).matches("^U-[a-zA-Z]{5}-[0-9]{3}$")) {
            throw new DataFormatException(String.format("Invalid user identifier. Expected U-XXXXX-000. Found %s", this.getField(3)));
        } else if(!this.getField(4).matches("^I-[a-zA-Z]{5}-[0-9]{3}$")) {
            throw new DataFormatException(String.format("Invalid product identifier. Expected I-XXXXX-000. Found %s", this.getField(4)));
        }

        return true;
    }

    @Override
	public int getLineType() {
		return IImport.SELL_ELEMENTS;
	}

    @Override
    protected int getExpectedFieldCount() {
        return 7;
    }
}