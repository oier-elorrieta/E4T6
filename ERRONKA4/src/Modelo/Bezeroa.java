package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 * Bezeroa klaseak eratzen duen Bezeroa objektua.
 */
public class Bezeroa {
    protected int id; // Bezeroaren identifikadorea
    protected String izena; // Bezeroaren izena
    protected String abizena; // Bezeroaren abizena
    protected String hizkuntza; // Bezeroaren hizkuntza
    protected String erabiltzailea; // Bezeroaren erabiltzailea
    protected String pasahitza; // Bezeroaren pasahitza
    protected Date jaiotzedata; // Bezeroaren jaiotze data
    protected Date erregistrodata; // Bezeroaren erregistro data
    protected Date premiummuga; // Bezeroaren premium muga
    protected boolean premium; // Bezeroa premium den ala ez

    /**
     * Bezeroaren konstruktorea.
     * 
     * @param izena Bezeroaren izena
     * @param abizena Bezeroaren abizena
     * @param hizkuntza Bezeroaren hizkuntza
     * @param erabiltzailea Bezeroaren erabiltzailea
     * @param pasahitza Bezeroaren pasahitza
     * @param jaiotzedata Bezeroaren jaiotze data
     * @param erregistrodata Bezeroaren erregistro data
     */
    public Bezeroa(String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
            Date jaiotzedata, Date erregistrodata) {
        this.izena = izena;
        this.abizena = abizena;
        this.hizkuntza = hizkuntza;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.jaiotzedata = jaiotzedata;
        this.erregistrodata = erregistrodata;

    }

    // Getter eta setter metodoak...

    @Override
    public String toString() {
        return "Bezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza
                + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", jaiotzedata=" + jaiotzedata
                + ", erregistrodata=" + erregistrodata + ", premiummuga=" + premiummuga + ", premium=" + premium + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(abizena, erabiltzailea, erregistrodata, hizkuntza, id, izena, jaiotzedata, pasahitza,
                premium, premiummuga);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bezeroa other = (Bezeroa) obj;
        return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzailea, other.erabiltzailea)
                && Objects.equals(erregistrodata, other.erregistrodata) && Objects.equals(hizkuntza, other.hizkuntza)
                && id == other.id && Objects.equals(izena, other.izena)
                && Objects.equals(jaiotzedata, other.jaiotzedata) && Objects.equals(pasahitza, other.pasahitza)
                && premium == other.premium && Objects.equals(premiummuga, other.premiummuga);
    }

}