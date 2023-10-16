/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicinfoapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MINHNHAT
 */
public class Server {

    private static final int PORT = 12346;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected :" + clientSocket.getInetAddress().getHostName());

                Thread clientHandler = new TCPThread(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
