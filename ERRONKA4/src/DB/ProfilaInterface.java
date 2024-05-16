package DB;

import Modelo.Bezeroa;
/**
 * Erabiltzailearen datuak lortzeko eta definitzeko
 */
public interface ProfilaInterface {
	
	 /**
     * Perfilaren datuak berreskuratzen ditu erabiltzailearen izenaren arabera
     *
     * @param erabiltzaile Berreskuratu behar den erabiltzailearen izena
     * @return Objeto Bezeroa erabiltzailearen datuak daukana
     */
	public Bezeroa bezeroaLortu(String erabiltzaile);
	
	/**
     * Actualiza los datos del perfil de un usuario en la base de datos. Erabiltzailearen profilaren datuak eguneratzen ditu
     *
     * @param bezeroa Objeto Bezeroa perfilaren datu eguneratuak
     * @param lehenegoBezeroa Erabiltzailearen lehenengo izena
     * @throws ProfilaSalbuespena Erroreren bat agertzen bada erabiltzailea berrezkuratzean
     */
	public void aktualizatuBezeroa(Bezeroa bezeroa, String lehenegoBezeroa);
	
	/**
     * Bi objetu konparatu ia berdinak diren
     *
     * @param bez1 Lehenengo objetua
     * @param bez2 Bigarren objetua
     * @return true berdinak badira, false desberdinak badira
     */
	public boolean bezKomparaketa(Bezeroa bez1, Bezeroa bez2);
}
