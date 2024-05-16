package Modelo;

import java.util.Objects;

/**
 * Podcast klaseak eratzen duen Podcast objektua.
 */
public class Podcast {
    
    /** Podcast-en kolaboratzaileak. */
    protected String kolaboratzaileak;

    /**
     * Podcastaren eraikitzailea.
     *
     * @param kolaboratzaileak Podcast-en kolaboratzaileak.
     */
    public Podcast(String kolaboratzaileak) {
        this.kolaboratzaileak = kolaboratzaileak;
    }

    /**
     * Podcast-en kolaboratzaileak itzultzen ditu.
     *
     * @return Podcast-en kolaboratzaileak.
     */
    public String getKolaboratzaileak() {
        return kolaboratzaileak;
    }

    /**
     * Podcast-en kolaboratzaileak ezartzen ditu.
     *
     * @param kolaboratzaileak Ezarri nahi den Podcast-en kolaboratzaileak.
     */
    public void setKolaboratzaileak(String kolaboratzaileak) {
        this.kolaboratzaileak = kolaboratzaileak;
    }

    /**
     * Podcastaren String errepresentazioa itzultzen du.
     *
     * @return Podcastaren String errepresentazioa.
     */
    @Override
    public String toString() {
        return "Podcast [kolaboratzaileak=" + kolaboratzaileak + "]";
    }

    /**
     * Podcastaren kodea itzultzen du.
     *
     * @return Podcastaren kodea.
     */
    @Override
    public int hashCode() {
        return Objects.hash(kolaboratzaileak);
    }

    /**
     * Bi Podcast arteko berdintasuna konprobatzen du.
     *
     * @param obj Konparatzeko Podcasta.
     * @return Bi Podcast arteko berdintasuna badago true, bestela false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Podcast other = (Podcast) obj;
        return Objects.equals(kolaboratzaileak, other.kolaboratzaileak);
    }
}
