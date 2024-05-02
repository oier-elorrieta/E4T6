package Main;

import Vista.ArtistaVi;
import Vista.AlbumVi;
import Vista.ArtistaListVi;
import Vista.ErregistroaVi;
import Vista.LogInVi;
import Vista.MenuaVi;

public class Main {

    /**
     * Programaren exekuzioa hasi, LogIn pantaila bistaratuz.
     * 
     * @param args Komando lerroko argumentuak (erabiltzen ez direnak).
     */
    public static void main(String[] args) {
       
        LogInVi frame = new LogInVi();
        frame.setVisible(true);
     
    }
}