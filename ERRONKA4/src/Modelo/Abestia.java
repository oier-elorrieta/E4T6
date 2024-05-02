package Modelo;
import java.util.Objects;

public class Abestia extends Audio{

    /**
     * Abestiaren konstruktorea.
     * 
     * @param id Abestiaren identifikadorea
     * @param izena Abestiaren izena
     * @param erreprodukzioak Abestiaren erreprodukzioak
     * @param iraupena Abestiaren iraupena minutuetan
     */
    public Abestia(int id, String izena, String erreprodukzioak, double iraupena) {
        super(id, izena, erreprodukzioak, iraupena);
    }

    protected String ezaugarria;

    /**
     * Abestiaren ezaugarriaren getter metoda.
     * 
     * @return Abestiaren ezaugarria
     */
    public String getEzaugarria() {
        return ezaugarria;
    }

    /**
     * Abestiaren ezaugarriaren setter metoda.
     * 
     * @param ezaugarria Abestiaren ezaugarria
     */
    public void setEzaugarria(String ezaugarria) {
        this.ezaugarria = ezaugarria;
    }

    @Override
    public String toString() {
        return "Abestia [ezaugarria=" + ezaugarria + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ezaugarria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Abestia other = (Abestia) obj;
        return Objects.equals(ezaugarria, other.ezaugarria);
    }
}