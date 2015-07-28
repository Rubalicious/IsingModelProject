package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

import Model.IsingModel;



@SuppressWarnings("serial")
public class Controller extends JFrame {
	//GLOBAL VARIABLES

	//the run button
	private boolean run = false;
	
//	the Timer for the ising model
	private Timer t = new Timer(1, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			step();
		}
	});
//	the Timer to track when to refresh
	private Timer repaintTimer = new Timer(100, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	});
	
	//Size of Panel
	private static int SIZE = 500;
	
	//model
	private IsingModel simulation = new IsingModel(SIZE);
	
	//view
	private JPanel [][] view = new JPanel[SIZE/5][SIZE/5];
	
	//Constructor
	public Controller(){
		super("Ising Model Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 100);
//		setLayout(new BorderLayout());
		int sizeOfRunButton = 73;
		setPreferredSize(new Dimension(SIZE,SIZE+sizeOfRunButton));
		setSize(new Dimension(SIZE,SIZE));
		this.setResizable(false);
//		this.setBackground(Color.YELLOW);
		
		
		//the menu bar
		JMenuBar theMenuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem about = new JMenuItem("about");
		
		//adding responsiveness to the menu bar
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, new JLabel("some string"));
			}
		});
		file.add(about);
		theMenuBar.add(file);
		setJMenuBar(theMenuBar);
		
		// initializing view
		setUpView();
		
		JButton runButton = new JButton("run");

		//add in a dropdown box for pixels
		
		int time = 0;
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				run = !run;
				if(run){
					runButton.setText("pause");
					t.start();
					repaintTimer.start();
				}
				else{
					runButton.setText("run");
					t.stop();
					repaintTimer.stop();
					System.out.println("stop: "+ (time - t.getDelay()));
				}
			}
		});
		
		//To be added
		JSlider slider = new JSlider();
		slider.addComponentListener(new ComponentListener(){
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e){
				
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(slider, BorderLayout.SOUTH);
		add(runButton, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	private Color up = Color.YELLOW;
	private Color dn = Color.BLUE;
	private void setUpView() {
		for (int i = 1; i < view.length-1; i ++){
			for (int j = 1; j < view[0].length-1; j++){
				view[i][j] = new JPanel(new BorderLayout());
				view[i][j].setLocation(5*i, 5*j);
				view[i][j].setSize(5, 5);
				if(simulation.getOrientation(i, j)==0){
					view[i][j].setBackground(up);
				}
				else{
					view[i][j].setBackground(dn);
				}
				add(view[i][j], BorderLayout.CENTER);
			}
		}
		
	}
	
	private void step(){
		int x = (int)(Math.random()*simulation.size());
		int y = (int)(Math.random()*simulation.size());
		simulation.acceptDecision(x, y);
		setUpView();
	}
	
	public void paintComponent(){
		for (int i = 0; i < view.length; i++){
			for (int j = 0; j < view[0].length; j++){
				if(simulation.getOrientation(i, j)==1){
					view[i][j].setBackground(up);
				}
				else{
					view[i][j].setBackground(dn);
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main (String [] args){
		Controller window = new Controller(); 
	}
	
}

