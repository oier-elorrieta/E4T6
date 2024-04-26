package Main;

import Vista.Artista;
import Vista.ArtistaList;
import Vista.Erregistroa;
import Vista.LogIn;
import Vista.Menua;

public class Main {

    public static void main(String[] args) {
       
        LogIn frame = new LogIn();
        frame.setVisible(true);
        
        Erregistroa registroFrame = new Erregistroa();
        
        Menua menuFrame = new Menua();
        
        ArtistaList artistaListFrame = new ArtistaList();
        
        Artista artistaFrame = new Artista(-1);
        
     
    }
}