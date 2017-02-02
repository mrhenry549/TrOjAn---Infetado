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
import javax.imageio.ImageIO;

public class SendPic{
    
    DataOutputStream out;

    public SendPic() throws IOException, AWTException {

        Robot rob= new Robot();
        BufferedImage image = rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("screenshot.jpg"));
        File file = new File("screenshot.jpg");
        FileInputStream fis =new FileInputStream(file);
            int i;
            do
            {
                i=fis.read();
                out.writeUTF(String.valueOf(i));
            }
            while(i!=-1);    
            fis.close();    
            out.writeUTF("Screenshot recebida!");  

    }

}
