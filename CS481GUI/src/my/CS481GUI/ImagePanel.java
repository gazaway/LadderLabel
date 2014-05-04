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
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * @author Jim
 */
public class ImagePanel extends JPanel {

	private BufferedImage image;
	private BufferedImage copy;
	double scaledY = 0, scaledX = 0, scaled = 0;
	private Rectangle rect = null;
	private boolean drawing = false;
	private boolean allowDraw = false;
	MyMouseAdapter mouseAdapter = new MyMouseAdapter();
	int dx = 0;
	int dy = 0;

	public BufferedImage getImage(){
		return image;
	}
	
	public void setImage(String in){
		this.removeAll();
		try {
			image = ImageIO.read(new File(in));
			copy = ImageIO.read(new File(in));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		Graphics g = getGraphics();
		paintComponent(g);
		repaint();
	}
	
	public ImagePanel() {
		try {
			image = ImageIO.read(new File("img/LadderWoz.jpg"));
			copy = ImageIO.read(new File("img/LadderWoz.jpg"));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void runCrop() {
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		allowDraw = true;
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		drawImage(g2);
		if (allowDraw) {
			if (rect == null) {
				return;
			} else if (drawing) {
				g2.setColor(new Color(0, 154, 255));
				Stroke oldStroke = g2.getStroke();
				g2.setStroke(new BasicStroke(3));
				g2.draw(rect);
			} else {
				g2.setColor(new Color(0, 154, 255));
				Stroke oldStroke = g2.getStroke();
				g2.setStroke(new BasicStroke(3));
				g2.draw(rect);
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				g2.clearRect(0, 0, this.getWidth(), this.getHeight());
				this.removeAll();
				image = image.getSubimage((int)(rect.getX()/scaledX), (int)(rect.getY()/scaledY), (int)(rect.getWidth()/scaledX), (int)(rect.getHeight()/scaledY));
				copy = image.getSubimage((int)(rect.getX()/scaledX), (int)(rect.getY()/scaledY), (int)(rect.getWidth()/scaledX), (int)(rect.getHeight()/scaledY));
				drawImage(g2);
				repaint();
				allowDraw = false;
				removeMouseListener(mouseAdapter);
				rect = null;
			}
		}
		copy = image;
	}
	
	public void changeBrightness(int val){
		RescaleOp op = new RescaleOp((float)(1.0 + (val / 1000.0)), 0, null);
		image = op.filter(copy, image);
		repaint();
	}
	
	public void changeContrast(int val){
		RescaleOp op = new RescaleOp(0, val, null);
		image = op.filter(copy, image);
		repaint();
	}
	
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  

	private void drawImage(Graphics2D g2) {
		double newW = 0;
		double newH = 0;
		scaledX = (double)(this.getWidth()/image.getWidth());
		scaledY = (double)(this.getHeight()/image.getHeight());
		try {
			image = resizeImage(image, this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			copy = resizeImage(image, this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
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
