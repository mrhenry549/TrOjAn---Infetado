/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author UserPL022Pc15
 */
public class RecieveNum {
    DataInputStream din;
    public String numero;

    public RecieveNum() {
        try {

            ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

           din = new DataInputStream(sock.getInputStream());
           
           din.readUTF();
           
           numero = din.readUTF();

        } catch (Exception e) {

        }
    }
}
