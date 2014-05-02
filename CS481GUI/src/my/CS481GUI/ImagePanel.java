/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.CS481GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jim
 */
public class ImagePanel extends JPanel{
    
    private BufferedImage image;
    
    public ImagePanel() {
        try {
            image = ImageIO.read(new File("img/LadderWoz.jpg"));
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    protected void paintComponent(Graphics g){
    	Graphics2D g2 = (Graphics2D)g;
        int newW = 717;
        int newH = 650;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, newW, newH, null);
    }
}
