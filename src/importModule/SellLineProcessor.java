package importModule;


import model.data.ImportData;

import java.util.Date;

public class SellLineProcessor extends LineProcessor {
	public SellLineProcessor() {
		super("");
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
