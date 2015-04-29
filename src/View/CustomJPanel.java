package View;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Model.IsingModel;

public class CustomJPanel extends JPanel {
	private IsingModel simulation;
	public CustomJPanel(IsingModel sim){
		simulation = sim;
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
	}
	public void step(){
		int x = (int)(Math.random()*simulation.size());
		int y = (int)(Math.random()*simulation.size());
		simulation.acceptDecision(x, y);
	}

}
