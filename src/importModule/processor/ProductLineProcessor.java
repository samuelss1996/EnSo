package importModule.processor;


import importModule.IImport;
import model.ImportData;
import model.data.Product;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class ProductLineProcessor extends LineProcessor {

    public ProductLineProcessor(String line, Date minDate) throws DataFormatException {
		super(line, minDate);
	}

	@Override
	public void processLine(ImportData data) throws DataFormatException {
        try {
            Date availableSince = DateFormat.getDateInstance(DateFormat.SHORT, Locale.forLanguageTag("es")).parse(this.getField(2));
            Product product = new Product();

            if (this.shouldBeImportedBasedOnDate(availableSince) && this.checkFieldsFormat()) {
                product.setId(this.getField(1));
                product.setAvailableSince(availableSince);
                product.setName(this.getField(3));
                product.setCategory(this.getField(4));
                product.setStock(Integer.valueOf(this.getField(5)));
                product.setDescription(this.getField(6));

                data.addProduct(product);
            }
        } catch (ParseException e) {
            throw new DataFormatException(String.format("Invalid date format. Expected dd/mm/aaaa. Found %s", this.getField(2)));
        } catch (NumberFormatException e) {
            throw new DataFormatException(String.format("Field must be an integer. Field index: %d. Line: %s", 5, this.getLine()));
        }
    }

    /**
     * Checks if all the fields have the correct format for a product line
     * @return True if all the fields have the correct format
     * @throws DataFormatException If any of the fields has an invalid format
     */
    private boolean checkFieldsFormat() throws DataFormatException {
        if(!this.getField(1).matches("^I-[a-zA-Z]{5}-[0-9]{3}$")) {
            throw new DataFormatException(String.format("Invalid product identifier. Expected I-XXXXX-000. Found %s", this.getField(1)));
        }

        return true;
    }

	@Override
	public int getLineType() {
		return IImport.ITEM_ELEMENTS;
	}

    @Override
    protected int getExpectedFieldCount() {
        return 7;
    }
}