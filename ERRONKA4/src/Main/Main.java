package Main;

import Vista.ArtistaVi;
import Vista.ArtistaListVi;
import Vista.ErregistroaVi;
import Vista.LogInVi;
import Vista.MenuaVi;

public class Main {

    public static void main(String[] args) {
       
        LogInVi frame = new LogInVi();
        frame.setVisible(true);
        
        ErregistroaVi registroFrame = new ErregistroaVi();
        
        MenuaVi menuFrame = new MenuaVi();
        
        ArtistaListVi artistaListFrame = new ArtistaListVi();
        
        ArtistaVi artistaFrame = new ArtistaVi(-1);
        
     
    }
}