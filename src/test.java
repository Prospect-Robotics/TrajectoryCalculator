import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test  {

	private static int width = 500;
	private static int height = 600;
	
	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame();
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.setVisible(true);
		Timer time = new Timer();
		Random random = new Random();
		while(true){
			frame.add(new mirrorPoint(random.nextInt(frame.getWidth()),random.nextInt(frame.getHeight())));
			frame.setVisible(true);
		}
		

	}
	
}

class mirrorPoint extends JComponent{
	
	private double x;
	private double y;
	public mirrorPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g){

		Flipper flip = new Flipper();

		double[] ellipsePos = {this.x,this.y};
		double[] ellipseSize = {10,10};
		double[] flippedCoords = flip.flipXY(ellipsePos[0] - ellipseSize[0]/2, ellipsePos[1] - ellipseSize[1]/2, getWidth() , getHeight());
		((Graphics2D) g).fill(new Ellipse2D.Double(flippedCoords[0], flippedCoords[1], ellipseSize[0], ellipseSize[1]));


		
	}
	
}

