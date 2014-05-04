package my.CS481GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private Rectangle rect = null;
    private boolean drawing = false;
    private boolean allowDraw = false;
    
    public ImagePanel() {
        try {
            image = ImageIO.read(new File("img/LadderWoz.jpg"));
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    public void runCrop(){
    	MyMouseAdapter mouseAdapter = new MyMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    	this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    	allowDraw = true;
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
		if (allowDraw) {
			if (rect == null) {
				return;
			} else if (drawing) {
				g2.setColor(Color.red);
				Stroke oldStroke = g2.getStroke();
				g2.setStroke(new BasicStroke(5));
				g2.draw(rect);
			} else {
				g2.setColor(Color.red);
				g2.draw(rect);
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				allowDraw = false;
			}
		}
    }
    private class MyMouseAdapter extends MouseAdapter {
        private Point mousePress = null; 
        @Override
        public void mousePressed(MouseEvent e) {
           mousePress = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
           drawing = true;
           int x = Math.min(mousePress.x, e.getPoint().x);
           int y = Math.min(mousePress.y, e.getPoint().y);
           int width = Math.abs(mousePress.x - e.getPoint().x);
           int height = Math.abs(mousePress.y - e.getPoint().y);

           rect = new Rectangle(x, y, width, height);
           repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           drawing = false;
           repaint();
        }

     }
}
