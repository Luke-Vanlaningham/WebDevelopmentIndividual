package GraphsScreenSaver;

import java.awt.Color;

import javax.swing.JFrame;




public class MrFrame extends JFrame  {
	myPanel panel;
	MrFrame()
	{
		panel = new myPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500,800);
		this.add(panel);
		this.pack();
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		

	}


}
