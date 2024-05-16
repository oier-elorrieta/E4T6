package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 * Premium klaseak eratzen duen Premium objektua.
 */
public class Premium extends Bezeroa{

    /** Premium-aren iraungitze data. */
    protected Date iraungitzedata;
    
    /**
     * Premium-aren eraikitzailea.
     *
     * @param id Bezeroaren identifikatzailea.
     * @param izena Bezeroaren izena.
     * @param abizena Bezeroaren abizena.
     * @param hizkuntza Bezeroaren hizkuntza.
     * @param erabiltzailea Bezeroaren erabiltzailea.
     * @param pasahitza Bezeroaren pasahitza.
     * @param jaiotzedata Bezeroaren jaiotze data.
     * @param erregistrodata Bezeroaren erregistro data.
     * @param iraungitzedata Premium-aren iraungitze data.
     */
    public Premium(int id, String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
            Date jaiotzedata, Date erregistrodata, Date iraungitzedata) {
        super(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
        this.iraungitzedata = iraungitzedata;
    }

    /**
     * Premium-aren iraungitze data itzultzen du.
     *
     * @return Premium-aren iraungitze data.
     */
    public Date getIraungitzedata() {
        return iraungitzedata;
    }

    /**
     * Premium-aren iraungitze data ezartzen du.
     *
     * @param iraungitzedata Ezarri nahi den Premium-aren iraungitze data.
     */
    public void setIraungitzedata(Date iraungitzedata) {
        this.iraungitzedata = iraungitzedata;
    }

    @Override
    public String toString() {
        return "Premium [iraungitzedata=" + iraungitzedata + ", izena=" + izena + ", abizena=" + abizena
                + ", hizkuntza=" + hizkuntza + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza
                + ", jaiotzedata=" + jaiotzedata + ", erregistrodata=" + erregistrodata + ", premiummuga=" + premiummuga
                + ", premium=" + premium + "]";
    }
}
