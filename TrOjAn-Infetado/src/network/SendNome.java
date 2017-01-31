/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;


public class SendNome {
    
    RecieveNum rn;
    
    public SendNome() {
        
        File pasta = new File("C:/ftp/");
        File[] listaDeFicheiros = pasta.listFiles();

        try {
            Socket sock = new Socket("192.168.250.158", 80);

            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
            String msgout = listaDeFicheiros[Integer.parseInt(rn.getRead())].toString();
            
            dout.writeUTF(msgout);
            dout.flush();

        } catch (Exception e) {

        }

    }
}
