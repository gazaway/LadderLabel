package my.CS481GUI;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jim
 */
public class ImagePanel extends JPanel{
    
    private BufferedImage image;
    Rectangle clip;
    boolean showClip;
    
    public ImagePanel() {
        try {
            image = ImageIO.read(new File("img/LadderWoz.jpg"));
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    public void runCrop(){
    	this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }
    
    protected void paintComponent(Graphics g){
    	Graphics2D g2 = (Graphics2D)g;
        double newW = 0;
        double newH = 0;
        if (image.getWidth() > image.getHeight()){
        	newW = this.getWidth();
        	newH = (image.getHeight() * (newW / image.getWidth()));
        }
        else {
        	newH = this.getHeight();
        	newW = (image.getWidth() * (newH / image.getHeight()));
        	System.out.println("Width < " + newW + " " + newH);
        }
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (image.getHeight() > image.getWidth()){
        	g2.drawImage(image, (this.getWidth() - image.getWidth())/2, 0, (int)newW, (int)newH, null);
        }
        else {
        	g2.drawImage(image, 0, (this.getHeight() - image.getHeight())/2, (int)newW, (int)newH, null);
        }  
    }
}
