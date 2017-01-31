package network;

import java.io.*;
import java.net.*;

public class ServerPic{

    public ServerPic() throws IOException {

        try {
            ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

            File myfile = new File("D:/screenshot.jpg");

            while (true) {

                byte[] mybytearray = new byte[(int) myfile.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
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
