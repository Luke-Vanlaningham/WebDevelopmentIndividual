package GraphsScreenSaver;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class myPanel extends JPanel implements MouseListener,ActionListener {
	int[] Xpoints,Ypoints;
	int[][] edgeMatrix;
	int radius, numVertices,maxSpeed;
	double probability;
	boolean isDragging;
	int SelectedVertex,XAdjust,YAdjust;
	int thickness;
	int numCrossings;
	int Max;
	int Min;
	Timer timer;
	myPanel()
	{
		Max = 0;
		Min = 9999999;
		 timer = new Timer(0,this);
		 timer.start();
		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(1500,800));
		this.setBackground(Color.WHITE);
		isDragging = false;
		thickness = 10;
		probability = 1;
		radius = 10;
		numVertices = 5;
		edgeMatrix = new int[numVertices][numVertices];
		maxSpeed = 20;
		// graph initialization
		Xpoints = new int[numVertices];
		Ypoints = new int[numVertices];
		
		for(int i = 0;i<numVertices;i++)
		{
			Xpoints[i]=(int)(Math.random()*(700-radius)+300);
			Ypoints[i]=(int)(Math.random()*(700-radius)+100);
			
		}
		
		
		//Edges initialization
		
		for(int i = 0;i<edgeMatrix.length;i++)
		{
			for(int j = i+1;j<edgeMatrix.length;j++)
			{
				if(i==j)
				{
					edgeMatrix[i][j]=0;
				}
				else
				{
					double random = Math.random();
					if(random<probability)
					{
						edgeMatrix[i][j]=1;
						edgeMatrix[j][i]=1;
					}
					else if(edgeMatrix[i][j]==0)
					{

						edgeMatrix[i][j]=-1;
						edgeMatrix[j][i]=-1;
					}
				}
				
			}
		}
	
	}
	public void paint(Graphics g)
	{
	
		super.paint(g);
		Graphics2D g2D= (Graphics2D) g;
		
		
		int count = 0;
		 Font font = new Font("Verdana", Font.BOLD, 20);
		 g2D.setFont(font);
		g2D.drawString("Current # Crossings \n"+String.valueOf(numCrossings), 0, 20);
		g2D.drawString("Maximum observed"+String.valueOf(Max), 0, 40);
		g2D.drawString("Minimum observed"+String.valueOf(Min), 0, 60);
		if(numCrossings==Max||numCrossings==Min)
		{
			g2D.setColor(Color.GREEN);
			g2D.drawString("Current # Crossings \n"+String.valueOf(numCrossings), 0, 20);
		}
		
		for(int i = 0;i<Xpoints.length;i++)
		{
			for(int j = 0;j<Xpoints.length;j++)
			{
				if(edgeMatrix[i][j]==1)
				{
					g2D.setColor(Color.BLACK);
				    g2D.setStroke(new BasicStroke(thickness));

					g2D.drawLine(Xpoints[i], Ypoints[i], Xpoints[j], Ypoints[j]);
					
				}
				count++;
			}
		}
		for(int i = 0;i<Xpoints.length;i++)
		{
			g2D.setColor(Color.BLACK);
			
			if(i==SelectedVertex&&isDragging)
			{
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int x = (int) b.getX()-XAdjust;
				int y = (int) b.getY()-YAdjust;
				if((x>300||y>100)&&(x>0)&&(y>0)&&(x<1500))
				{
					Xpoints[i]=x;
					Ypoints[i]=y;
				}
				else
				{
					
					timer.stop();
					isDragging = false;
				}
				
			}
			g2D.fillArc(Xpoints[i]-radius,Ypoints[i]-radius, 2*radius, 2*radius, 0, 360);
			
			
		}
		numCrossings = 0;
		for(int i = 0;i<numVertices;i++)
		{
			for(int j = 0;j<numVertices;j++)
			{
				for(int k = 0;k<numVertices;k++)
				{
					for(int l = 0;l<numVertices;l++)
					{
						if((i==k)||(j==l)||(edgeMatrix[i][j]!=1)||(edgeMatrix[k][l]!=1)||(i==l&&j==k))
						{
							continue;
						}
						else
						{
							int x1=Xpoints[i];
							int y1=Ypoints[i];
							int x2=Xpoints[j];
							int y2=Ypoints[j];
							int x3=Xpoints[k];
							int y3=Ypoints[k];
							int x4=Xpoints[l];
							int y4=Ypoints[l];
							long ImportantOne=(x3-x1)*(y2-y1)-(y3-y1)*(x2-x1);
							long ImportantTwo=(x4-x1)*(y2-y1)-(y4-y1)*(x2-x1);
							long ImportantThree=(x1-x3)*(y4-y3)-(y1-y3)*(x4-x3);
							long ImportantFour=(x2-x3)*(y4-y3)-(y2-y3)*(x4-x3);
							

						if((ImportantOne*ImportantTwo<0)&&(ImportantThree*ImportantFour<0))
						{
							
							numCrossings++;
						}
					
						}
					}
				}
			}
		}
		numCrossings = numCrossings/8;
		if(numCrossings>Max)
		{
			Max = numCrossings;
		}
		if(numCrossings<Min)
		{
			Min = numCrossings;
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
	
		for(int i = 0;i<numVertices;i++)
		{
			if(Math.pow(x-Xpoints[i], 2)+Math.pow(y-Ypoints[i], 2)<=Math.pow(radius, 2))
			{
				isDragging = true;
				SelectedVertex = i;
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int fakeX = (int) b.getX();
				int fakeY = (int) b.getY();
				XAdjust=fakeX-x;
				YAdjust=fakeY-y;
				timer.start();
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		isDragging = false;
		timer.stop();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	

	
}
