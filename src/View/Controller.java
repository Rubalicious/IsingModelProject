package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.Timer;


public class Controller extends JFrame {
	private boolean run = false;
	private Timer t = new Timer(10, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			ising.step();
		}
	});
	private Timer repaintTimer = new Timer(100, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	});
	CustomJPanel ising;
	public Controller(){
		super("Ising Model Simulation");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500,500));
		
		JMenuBar theMenuBar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenuItem about = new JMenuItem("about");
		
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, new JLabel("some string"));
			}
		});
		file.add(about);
		theMenuBar.add(file);
		setJMenuBar(theMenuBar);
		
		ising = new CustomJPanel(null);
		
		JButton runButton = new JButton("Run");
		JSlider slider = new JSlider();

		//add in a dropdown box for pixels
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				run = !run;
				if(run){
					runButton.setText("pause");
					t.start();
				}
				else{
					runButton.setText("run");
					t.stop();
				}
			}
		});
		
		add(ising, BorderLayout.CENTER);
		add(slider, BorderLayout.SOUTH);
		add(runButton, BorderLayout.SOUTH);
		setSize(new Dimension(500,500));
		pack();
		repaintTimer.start();
		setVisible(true);
	}
	
	public static void main (String [] args){
		Controller window = new Controller(); 
	}
	
}
//google Observer and Observable
//use a swing timer
//Java graphics and paint component
