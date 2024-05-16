package Salbuespenak;

/**
 * LogInSalbuespena klaseak eratzen duen LogInSalbuespena salbuespena.
 */
public class LogInSalbuespena extends Exception {
    
    /**
     * LogInSalbuespena klasearen eraikitzailea.
     */
    public LogInSalbuespena() {
        super("Erabiltzailea eta pasahitza ez dira zuzenak");
    }
}
