package statistics;

public interface StatisticsInterface {
	public int[] getValoresBrutos(int dias);
	public float getMedias(int dias);
	public int[] getHistogramas(int mode);
	public float[] getPorcentajes(int mode);
}