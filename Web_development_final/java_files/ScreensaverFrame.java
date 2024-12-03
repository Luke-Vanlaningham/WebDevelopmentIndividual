package GraphsScreenSaver;

import java.awt.Color;

import javax.swing.JFrame;




public class MrFrame extends JFrame  {
	myPanel panel;
	MrFrame()
	{
		panel = new myPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/*myPanel panel = new myPanel();
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.pack();
		this.add(panel);
		this.setSize(1500,800);
		this.setVisible(true);*/
		

	}


}
