package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.IsingModel;


public class CustomJPanel extends JPanel {
	
	private static int SIZE = 10;
	private IsingModel simulation;
	private JLabel [][] pixel = new JLabel [SIZE][SIZE];
	
	public CustomJPanel(IsingModel sim){
		simulation = sim;
		SIZE = simulation.size();
		setSize(100, 100);
		setLayout(new BorderLayout());
		setVisible(true);
		setUpPixels();
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
		//[][] color objects

		
		
	}
	public void step(){
		int x = (int)(Math.random()*simulation.size());
		int y = (int)(Math.random()*simulation.size());
		simulation.acceptDecision(x, y);
	}

}
