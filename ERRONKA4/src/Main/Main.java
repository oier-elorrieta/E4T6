package Main;

import Vista.ArtistaVi;
import Vista.ArtistaListVi;
import Vista.ErregistroaVi;
import Vista.LogInVi;
import Vista.MenuaVi;

public class Main {

    public static void main(String[] args) {

        int zbk = 0;

        while (zbk == 0){
            Sistem.out.println("mentxaaaaaaaakaaaaaaaaaaaaaaa")
        }
        
        LogInVi frame = new LogInVi();
        frame.setVisible(true);
        
        ErregistroaVi registroFrame = new ErregistroaVi();
        
        MenuaVi menuFrame = new MenuaVi();
        
        ArtistaListVi artistaListFrame = new ArtistaListVi();
        
        ArtistaVi artistaFrame = new ArtistaVi(-1);
        
     
    }
}
