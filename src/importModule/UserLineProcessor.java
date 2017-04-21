package importModule;


import model.ImportData;

import java.util.Date;

public class UserLineProcessor extends LineProcessor {
	public UserLineProcessor(String line) {
		super(line);
	}

	@Override
	public void processLine(ImportData data) {
	}

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public int getLineType() {
		return 0;
	}

}
