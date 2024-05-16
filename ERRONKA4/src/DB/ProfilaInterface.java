package DB;

import Modelo.Bezeroa;

public interface ProfilaInterface {
	public Bezeroa bezeroaLortu(String erabiltzaile);
	public void aktualizatuBezeroa(Bezeroa bezeroa, String lehenegoBezeroa);
	public boolean bezKomparaketa(Bezeroa bez1, Bezeroa bez2);
}
