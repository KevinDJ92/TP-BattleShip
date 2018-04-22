package views;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPan extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Image image;

	public MainPan() {
		
		
		try {
			image = ImageIO.read(getClass().getResource("/images/shipbackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

}

@Override
protected void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	super.paintComponent(g);
	g.drawImage(image, 0, 0, this);
}

}
