package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 * Bezeroa klaseak eratzen duen Bezeroa objektua.
 */
public class Bezeroa {
    protected int id;
    protected String izena;
    protected String abizena;
    protected String hizkuntza;
    protected String erabiltzailea;
    protected String pasahitza;
    protected Date jaiotzedata;
    protected Date erregistrodata;
    protected Date premiummuga;
    protected boolean premium;

    /**
     * Bezeroa klasearen eraikitzailea.
     * @param izena Bezeroaren izena.
     * @param abizena Bezeroaren abizena.
     * @param hizkuntza Bezeroaren hizkuntza.
     * @param erabiltzailea Bezeroaren erabiltzailea.
     * @param pasahitza Bezeroaren pasahitza.
     * @param jaiotzedata Bezeroaren jaiotze data.
     * @param erregistrodata Bezeroaren erregistro data.
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

    /**
     * IDaren getter metodoa.
     * @return Bezeroaren IDa.
     */
    public int getId() {
        return id;
    }

    /**
     * IDaren setter metodoa.
     * @param id Bezeroaren IDa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Izenaren getter metodoa.
     * @return Bezeroaren izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Izenaren setter metodoa.
     * @param izena Bezeroaren izena.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Abizenaren getter metodoa.
     * @return Bezeroaren abizena.
     */
    public String getAbizena() {
        return abizena;
    }

    /**
     * Abizenaren setter metodoa.
     * @param abizena Bezeroaren abizena.
     */
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    /**
     * Hizkuntzaren getter metodoa.
     * @return Bezeroaren hizkuntza.
     */
    public String getHizkuntza() {
        return hizkuntza;
    }

    /**
     * Hizkuntzaren setter metodoa.
     * @param hizkuntza Bezeroaren hizkuntza.
     */
    public void setHizkuntza(String hizkuntza) {
        this.hizkuntza = hizkuntza;
    }

    /**
     * Erabiltzailearen getter metodoa.
     * @return Bezeroaren erabiltzailea.
     */
    public String getErabiltzailea() {
        return erabiltzailea;
    }

    /**
     * Erabiltzailearen setter metodoa.
     * @param erabiltzailea Bezeroaren erabiltzailea.
     */
    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    /**
     * Pasahitzaren getter metodoa.
     * @return Bezeroaren pasahitza.
     */
    public String getPasahitza() {
        return pasahitza;
    }

    /**
     * Pasahitzaren setter metodoa.
     * @param pasahitza Bezeroaren pasahitza.
     */
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    /**
     * Jaiotze dataren getter metodoa.
     * @return Bezeroaren jaiotze data.
     */
    public Date getJaiotzedata() {
        return jaiotzedata;
    }

    /**
     * Jaiotze dataren setter metodoa.
     * @param jaiotzedata Bezeroaren jaiotze data.
     */
    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }

    /**
     * Erregistro dataren getter metodoa.
     * @return Bezeroaren erregistro data.
     */
    public Date getErregistrodata() {
        return erregistrodata;
    }

    /**
     * Erregistro dataren setter metodoa.
     * @param erregistrodata Bezeroaren erregistro data.
     */
    public void setErregistrodata(Date erregistrodata) {
        this.erregistrodata = erregistrodata;
    }

    /**
     * Premium mugaren getter metodoa.
     * @return Bezeroaren premium muga.
     */
    public Date getPremiummuga() {
        return premiummuga;
    }

    /**
     * Premium mugaren setter metodoa.
     * @param premiummuga Bezeroaren premium muga.
     */
    public void setPremiummuga(Date premiummuga) {
        this.premiummuga = premiummuga;
    }

    /**
     * Premium estatuko boolean-aren getter metodoa.
     * @return Bezeroaren premium estatua.
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Premium estatuko boolean-aren setter metodoa.
     * @param premium Bezeroaren premium estatua.
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

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
