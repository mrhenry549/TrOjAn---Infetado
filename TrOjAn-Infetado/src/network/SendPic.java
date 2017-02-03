package network;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class SendPic {

    DataOutputStream dos;
    OutputStream os;
    int i = 0;

    public SendPic() throws IOException, AWTException {

        ServerSocket servsock = new ServerSocket(80);
        Socket sock = servsock.accept();
        Robot rob = new Robot();
        BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("screenshot.jpg"));
        FileInputStream fis = new FileInputStream("screenshot.jpg");
        DataOutputStream os = new DataOutputStream(sock.getOutputStream());
        while ((i = fis.read()) > -1) {
            os.write(i);
        }
        fis.close();
        os.close();
        sock.close();

    }

}
