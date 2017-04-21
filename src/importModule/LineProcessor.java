package importModule;


import model.ImportData;

import java.util.Date;

public abstract class LineProcessor {
	public LineProcessor(String line) {
	}
	
	public static LineProcessor getLineProcessorFor(String line) { return null;}
	
	public abstract void processLine(ImportData data);
	
	public abstract Date getDate();
	
	public abstract int getLineType();
}
