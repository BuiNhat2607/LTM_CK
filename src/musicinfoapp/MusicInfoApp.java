/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicinfoapp;
import client.frmSearchMusic;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 *
 * @author MINHNHAT
 */
public class MusicInfoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmSearchMusic frm=new frmSearchMusic();
        frm.setVisible(true);

    }
    
}
