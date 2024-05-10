package Modelo;

import java.util.Objects;

/**
 * Abestia klaseak abestiak kudeatzeko egitura eskaintzen du.
 */
public class Abestia extends Audio{

    protected String ezaugarria;

    /**
     * Abestia klasearen eraikitzailea.
     * @param id Abestiaren IDa.
     * @param izena Abestiaren izena.
     * @param erreprodukzioak Erreprodukzioak.
     * @param iraupena Abestiaren iraupena.
     */
    public Abestia(int id, String izena, String erreprodukzioak, double iraupena) {
        super(id, izena, erreprodukzioak, iraupena);
    }

    /**
     * Ezaugarriaren getter metodoa.
     * @return Abestiaren ezaugarria.
     */
    public String getEzaugarria() {
        return ezaugarria;
    }

    /**
     * Ezaugarriaren setter metodoa.
     * @param ezaugarria Abestiaren ezaugarria.
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
