package Modelo;

import java.sql.Date;

/**
 * FreeBezero klaseak eratzen duen FreeBezero objektua.
 */
public class FreeBezero extends Bezeroa {

    /**
     * FreeBezero klasearen eraikitzailea.
     * @param id Bezeroaren IDa.
     * @param izena Bezeroaren izena.
     * @param abizena Bezeroaren abizena.
     * @param hizkuntza Bezeroaren hizkuntza.
     * @param erabiltzailea Bezeroaren erabiltzailea.
     * @param pasahitza Bezeroaren pasahitza.
     * @param jaiotzedata Bezeroaren jaiotze data.
     * @param erregistrodata Bezeroaren erregistro data.
     */
    public FreeBezero(int id, String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
            Date jaiotzedata, Date erregistrodata) {
        super(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
    }

}
