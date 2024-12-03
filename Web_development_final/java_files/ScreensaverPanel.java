package GraphsScreenSaver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class myPanel extends JPanel implements ActionListener,MouseListener {
	int[] Xpoints,Ypoints,Xvelocity,Yvelocity;
	int[]  TwoXpoints,TwoYpoints,TwoXvelocity,TwoYvelocity;
	boolean[] edges;
	int radius, numVertices,maxSpeed;
	Timer timer;
	myPanel()
	{
		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(1000,800));
		this.setBackground(Color.BLACK);
		radius = 5;
		numVertices = 3;
		maxSpeed = 6;
		double probability = .5;
		// first graph initialization
		Xpoints = new int[numVertices];
		Ypoints = new int[numVertices];
		Xvelocity = new int[numVertices];
		Yvelocity = new int[numVertices]; 
		for(int i = 0;i<numVertices;i++)
		{
			Xpoints[i]=(int)(Math.random()*(500-2*radius)+radius);
			Ypoints[i]=(int)(Math.random()*(800-2*radius)+radius);
			Xvelocity[i]=(int)(Math.random()*2*maxSpeed-maxSpeed);
			Yvelocity[i]=(int)(Math.random()*maxSpeed-maxSpeed);
		}
		
		//second graph initialization
		TwoXpoints = new int[numVertices];
		TwoYpoints = new int[numVertices];
		TwoXvelocity = new int[numVertices];
		TwoYvelocity = new int[numVertices]; 
		for(int i = 0;i<numVertices;i++)
		{
			TwoXpoints[i]=(int)(Math.random()*(500-2*radius)+radius+500);
			TwoYpoints[i]=(int)(Math.random()*(800-2*radius)+radius);
			TwoXvelocity[i]=(int)(Math.random()*2*maxSpeed-maxSpeed);
			TwoYvelocity[i]=(int)(Math.random()*2*maxSpeed-maxSpeed);
		}
		//Edges initialization
		edges = new boolean[(Xpoints.length-1)*(Xpoints.length)/2];
		int count = 0;
		for(int i = 0;i<Xpoints.length;i++)
		{
			for(int j = i+1;j<Xpoints.length;j++)
			{
				double random = Math.random();
				if(random>1-probability)
				{
					edges[count]=true;
				}
				else
				{

					edges[count]=false;
				}
				count++;
			}
		}
		 timer = new Timer(50,this);
		 timer.start();
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2D= (Graphics2D) g;
		g2D.setColor(Color.BLUE);
		int count = 0;
		for(int i = 0;i<Xpoints.length;i++)
		{
			for(int j = i+1;j<Xpoints.length;j++)
			{
				if(edges[count])
				{
					g2D.setColor(Color.BLUE);
					g2D.drawLine(Xpoints[i], Ypoints[i], Xpoints[j], Ypoints[j]);
					g2D.setColor(Color.GREEN);
					g2D.drawLine(TwoXpoints[i], TwoYpoints[i], TwoXpoints[j], TwoYpoints[j]);

				}
				count++;
			}
		}
		for(int i = 0;i<Xpoints.length;i++)
		{
			g2D.setColor(Color.RED);

			g2D.fillArc(Xpoints[i]-radius,Ypoints[i]-radius, 2*radius, 2*radius, 0, 360);
			g2D.setColor(Color.YELLOW);
			g2D.fillArc(TwoXpoints[i]-radius,TwoYpoints[i]-radius, 2*radius, 2*radius, 0, 360);

		}
		g2D.setColor(Color.WHITE);
		g2D.drawRect(0, 0, 500, 800);
		g2D.drawRect(0, 0, 1000, 800);

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0;i<Xpoints.length;i++)
		{
			Xpoints[i]+=Xvelocity[i];
			Ypoints[i]+=Yvelocity[i];
			
			TwoXpoints[i]+=TwoXvelocity[i];
			TwoYpoints[i]+=TwoYvelocity[i];
			if(Xpoints[i]<radius)
			{				
				Xpoints[i]-=2*Xvelocity[i];
				Xvelocity[i] = -Xvelocity[i];
			
			}
			if(Ypoints[i]<radius)
			{
				Ypoints[i]-=2*Yvelocity[i];
				Yvelocity[i] = -Yvelocity[i];
				
		
			}
			if(Xpoints[i]>500-radius)
			{
				Xpoints[i]-=2*Xvelocity[i];
				Xvelocity[i]=-Xvelocity[i];
			}
			if(Ypoints[i]>800-radius)
			{
			Ypoints[i]-=2*Yvelocity[i];
			Yvelocity[i]=-Yvelocity[i];
			}
			
			if(TwoXpoints[i]<500+radius)
			{				
				TwoXpoints[i]-=2*TwoXvelocity[i];
				TwoXvelocity[i] = -TwoXvelocity[i];
			
			}
				
			if(TwoYpoints[i]<radius)
			{
				TwoYpoints[i]-=2*TwoYvelocity[i];
				TwoYvelocity[i] = -TwoYvelocity[i];
			}
			
			if(TwoXpoints[i]>1000-radius)
			{
				TwoXpoints[i]-=2*TwoXvelocity[i];
				TwoXvelocity[i]=-TwoXvelocity[i];
			}
			
			if(TwoYpoints[i]>800-radius)
			{
			TwoYpoints[i]-=2*TwoYvelocity[i];
			TwoYvelocity[i]=-TwoYvelocity[i];
			}
		}
		repaint();		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(timer.isRunning())
		{
			timer.stop();

		}
		else
		{
			timer.start();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
