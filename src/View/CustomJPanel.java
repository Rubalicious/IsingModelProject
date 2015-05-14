package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.IsingModel;


public class CustomJPanel extends JPanel {
	
	private IsingModel simulation;
	private static int SIZE;
	private JLabel [][] pixel = new JLabel [SIZE][SIZE];
	
	public CustomJPanel(IsingModel sim){
		simulation = sim;
		SIZE = simulation.size();
		setSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	private void setUpPixels() {
		for(int i = 0; i < SIZE; i ++){
			for(int j = 0; j <SIZE; j++){
				pixel[i][j] = new JLabel();
				pixel[i][j].setSize(5,5);
				//pixel[i][j].setLocation(5*i, 5*j);
				pixel[i][j].setBackground(Color.BLUE);
				this.add(pixel[i][j], BorderLayout.CENTER);
			}
		}
		
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension d = getSize();
		
		int gridWidth = d.width/SIZE;
		int gridHeight = d.height/SIZE;
		
		Color up = Color.BLUE;
		Color down = Color.YELLOW;
		for(int i = 0; i < simulation.size(); i++){
			for(int j = 0; j < simulation.size(); j++){
				if(simulation.getOrientation(i, j) == 0){
					g2.setPaint(up);
					g2.fillRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight);
				}
				else{
					g2.setPaint(down);
					g2.fillRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight);
				}
			}
		}
		

		
		
	}
	public void step(){
		int x = (int)(Math.random()*simulation.size());
		int y = (int)(Math.random()*simulation.size());
		simulation.acceptDecision(x, y);
	}

	public static void main (String [] args){
		//CustomJPanel panel = new CustomJPanel(null);
	}
}
