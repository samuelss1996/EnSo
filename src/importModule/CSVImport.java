package importModule;


import importModule.processor.LineProcessor;
import model.ImportData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.zip.DataFormatException;

public class CSVImport implements IImport {
	private String filePath;

    public CSVImport(String filePath) {
        this.filePath = filePath;
    }

    @Override
	public ImportData doImport(int... elements) throws DataFormatException, IOException {
		return this.doImport(null, elements);
	}

	@Override
	public ImportData doImport(Date dateFrom, int... elements) throws DataFormatException, IOException {
        ImportData importData = new ImportData();
        BufferedReader reader = new BufferedReader(new FileReader(this.filePath));

        for(String line; (line = reader.readLine()) != null; ){
            if(!line.trim().equals("")) {
                LineProcessor processor = LineProcessor.createLineProcessorFor(line, dateFrom);

                if(IntStream.of(elements).anyMatch(type -> type == processor.getLineType())) {
                    processor.processLine(importData);
                }
            }
        }

        return importData;
    }
}
