package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFile {
    
    int numero;
    DataInputStream din;

    public SendFile() throws IOException {

        try {

            ServerSocket servsock = new ServerSocket(80);
            File pasta = new File("D:/ftp/");
            File[] listaDeFicheiros = pasta.listFiles();

            while (true) {

                Socket sock = servsock.accept();
                //receber numero do ficheiro
                din = new DataInputStream(sock.getInputStream());
                numero = din.read();
                //enviar nome do ficheiro
                DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
                String msgout = listaDeFicheiros[numero].toString();
            
                dout.writeUTF(msgout);
                dout.flush();
                //enviar ficheiro
                byte[] mybytearray = new byte[(int) listaDeFicheiros[numero].length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(listaDeFicheiros[numero]));
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = sock.getOutputStream();
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();

            }

        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
