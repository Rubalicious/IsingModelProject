package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Controller extends JFrame {
	public Controller(){
		super("Ising Model Simulation");
		setLayout(new BorderLayout());
		
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
		
		JPanel display = new JPanel();
		JPanel buttons = new JPanel();
	}
	
}
//google Observer and Observable
//use a swing timer
//Java graphics and paint component
