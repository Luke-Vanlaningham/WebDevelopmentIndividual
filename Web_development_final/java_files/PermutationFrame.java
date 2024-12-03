package toughPuzzles;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame implements ActionListener{
	JButton ExecuteButton;
	JButton[] Moves;
	JButton scramble;
	JButton solve;
	int selectedMove;
	boolean doExecute;
	Grid myGrid;
	Function[] myMoves;
	int numMoves;
	int numRows;
	int numColumns;
	int squareSize;
	static Grid solved;
	int MovesPerformed;
	/*
	 * The variables for this class include all of the UI elements
	 * needed to play the game.  Many buttons, dimensions of pieces, and variables for specific playings of the game
	 */
 MyFrame(int mySize, int mynumRows, int mynumColumns, int mynumMoves)
{
	 /*
	  * The main method sets up the board that you are given to initially.  It may appear to have some complicated logic, 
	  * but it is mainly setting text, and setting the variables needed to play the game.  This does not paint the screen, that is
	  * what the next method does.
	  */
	MovesPerformed =0;
	squareSize = mySize;
	numRows=mynumRows;
	numColumns=mynumColumns;
	numMoves=mynumMoves;
	selectedMove=0;
	solved = new Grid(numRows,numColumns);
	solve = new JButton();
	solve.setBounds(squareSize*numColumns+25,100+50*numMoves,100,50);
	solve.addActionListener(this);
	solve.setText("solve");
	this.add(solve);
	 scramble = new JButton();
	scramble.setBounds(squareSize*numColumns+25,50+50*numMoves,100,50);
	scramble.addActionListener(this);
	scramble.setText("scramble");
	this.add(scramble);
	Moves= new JButton[numMoves];
	 ExecuteButton = new JButton();
	 ExecuteButton.setBounds(squareSize*numColumns+25,0,100,50);
	 ExecuteButton.addActionListener(this);
	 ExecuteButton.setText("Execute");
	this.add(ExecuteButton);
	 for(int i = 0;i<numMoves;i++)
	 {
		 Moves[i] = new JButton();
		 Moves[i].setBounds(squareSize*numColumns+25,50+50*i,100,50);
		 Moves[i].addActionListener(this);
		 Moves[i].setText("move "+String.valueOf(i+1));
		this.add(Moves[i]);
	 }
	    
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setSize(1500,800);
	this.setVisible(true);
	myGrid = new Grid(numRows,numColumns);
	myMoves = new Function[numMoves];
	
		for(int i = 0;i<numMoves;i++)
		{
			myMoves[i] = new Function(numRows,numColumns);
			myMoves[i].makeRandom();
		}
	for(int i = 0;i<numMoves;i++)
	{
		JLabel jlabel = new JLabel(myMoves[i].writtenMove());
	    jlabel.setBounds(squareSize*numColumns+100+25,50+50*i,800,50);
	    this.add(jlabel);
	}
	
}
MyFrame(int mySize, int mynumRows, int mynumColumns, int mynumMoves, Function[] TheMoves)
{
	/*
	 * this is an alternate constructor.  This is if you have chosen the moves for the game, while the previous constructor is 
	 * for if you want random moves in the game. 
	 */
	MovesPerformed =0;
	squareSize = mySize;
	numRows=mynumRows;
	numColumns=mynumColumns;
	numMoves=mynumMoves;
	selectedMove=0;
	solved = new Grid(numRows,numColumns);
	solve = new JButton();
	solve.setBounds(squareSize*numColumns+25,100+50*numMoves,100,50);
	solve.addActionListener(this);
	solve.setText("solve");
	this.add(solve);
	 scramble = new JButton();
	scramble.setBounds(squareSize*numColumns+25,50+50*numMoves,100,50);
	scramble.addActionListener(this);
	scramble.setText("scramble");
	this.add(scramble);
	Moves= new JButton[numMoves];
	 ExecuteButton = new JButton();
	 ExecuteButton.setBounds(squareSize*numColumns+25,0,100,50);
	 ExecuteButton.addActionListener(this);
	 ExecuteButton.setText("Execute");
	this.add(ExecuteButton);
	 for(int i = 0;i<numMoves;i++)
	 {
		 Moves[i] = new JButton();
		 Moves[i].setBounds(squareSize*numColumns+25,50+50*i,100,50);
		 Moves[i].addActionListener(this);
		 Moves[i].setText("move "+String.valueOf(i+1));
		this.add(Moves[i]);
	 }
	    
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setSize(1500,800);
	this.setVisible(true);
	myGrid = new Grid(numRows,numColumns);
	myMoves = new Function[numMoves];
	
	for(int i = 0;i<numMoves;i++)
	{
		myMoves[i]=TheMoves[i];
	}
	
	for(int i = 0;i<numMoves;i++)
	{
		JLabel jlabel = new JLabel(myMoves[i].writtenMove());
	    jlabel.setBounds(squareSize*numColumns+100+25,50+50*i,800,50);
	    this.add(jlabel);
	}
	
}
public void paint(Graphics g)
{
	/*
	 * this method is for painting the buttons, grid, and all elements on the frame.
	 */
	super.paint(g);
	Graphics2D g2D= (Graphics2D) g;
	g2D.setStroke(new BasicStroke(10));
	if(doExecute)
	{
		myGrid.doFunction(myMoves[selectedMove].getfunction());
		MovesPerformed++;
		doExecute=false;
	}
	for(int i = 0;i<myGrid.getRows();i++)
	{
		for(int j=0;j<myGrid.getColumns();j++)
		{
			if(solved.getElement(i, j)==myGrid.getElement(i, j))
			{
				g2D.setColor(Color.GREEN);
				g2D.fillRect(25+squareSize*j, 25+squareSize*i, squareSize, squareSize);
				g2D.setColor(Color.BLACK);
				g2D.drawRect(25+squareSize*j, 25+squareSize*i, squareSize, squareSize);

			}
			else
			{
				g2D.setColor(Color.RED);
				g2D.fillRect(25+squareSize*j, 25+squareSize*i, squareSize, squareSize);
				g2D.setColor(Color.BLACK);
				g2D.drawRect(25+squareSize*j, 25+squareSize*i, squareSize, squareSize);
			}
			
		}
	}
	for(int i = 0;i<myGrid.getRows();i++)
	{
		for(int j=0;j<myGrid.getColumns();j++)
		{
		g2D.setColor(Color.PINK);
		int value =myMoves[selectedMove].getElement(i,j);
		int xCoordinate =value%numColumns;
		int yCoordinate =(int)(value/numColumns);
		int x1=squareSize*j+25+squareSize/2;
		int y1=squareSize*i+25+squareSize/2;
		int x2=squareSize*xCoordinate+25+squareSize/2;
		int y2=squareSize*yCoordinate+25+squareSize/2;
		int ArcWidth = 50;
		if(x1!=x2||y1!=y2)
		{
			g2D.setStroke(new BasicStroke(5));
			if(x1==x2)
			{
				if(y1<y2)
				{
					g2D.drawArc((int) (x1-ArcWidth/2), y1,ArcWidth ,y2-y1, 90, 180);
				}
				if(y1>y2)
				{
					g2D.drawArc((int) (x2-ArcWidth/2), y2, ArcWidth,y1-y2, 270, 180);
				}
			}
			else if(y1==y2)
			{
				if(x1>x2)
				{
					g2D.drawArc(x2, (int) (y2-ArcWidth/2), x1-x2,ArcWidth, 0, 180);
				}
				if(x1<x2)
				{
					g2D.drawArc(x1, (int) (y1-ArcWidth/2), x2-x1,ArcWidth, 180, 180);
				}

			}
			else
			{
				g2D.drawLine(x1,y1,x2,y2);
			}
		}
		g2D.setColor(Color.BLUE);
		if(x1==x2)
		{
			
			if(y2==y1)
				continue;
			if(y2<y1)
			{	
				g2D.drawArc((int) (x2-ArcWidth/2), y2, ArcWidth,y1-y2, 270+180-25, 25);
				g2D.setColor(Color.MAGENTA);
				g2D.drawArc((int) (x2-ArcWidth/2), y2, ArcWidth,y1-y2, 270, 25);
			}
			if(y2>y1)
			{	
				g2D.drawArc((int) (x1-ArcWidth/2), y1,ArcWidth ,y2-y1, 270-25, 25);
				g2D.setColor(Color.MAGENTA);
				g2D.drawArc((int) (x1-ArcWidth/2), y1,ArcWidth ,y2-y1, 90, 25);

			}
			g2D.setStroke(new BasicStroke(10));
		}
		if(x2>x1)
		{	
			double slope = (y2-y1)/(x2-x1);
			if(y1==y2)
			{
				g2D.drawArc(x1, (int) (y1-ArcWidth/2), x2-x1,ArcWidth, 360-25, 25);
				g2D.setColor(Color.MAGENTA);
				g2D.drawArc(x1, (int) (y1-ArcWidth/2), x2-x1,ArcWidth, 180, 25);
			}
			else
			{
				g2D.drawLine(x2,y2,x2-5,(int)(y2-5*slope));
				g2D.setColor(Color.MAGENTA);
				g2D.drawLine(x1, y1, x1+5, (int)(y1+5*slope));
			}
		}
		if(x2<x1)
		{	
			double slope = (y2-y1)/(x2-x1);
			if(y1==y2)
			{	
				g2D.drawArc(x2, (int) (y2-ArcWidth/2), x1-x2,ArcWidth, 180-25, 25);
				g2D.setColor(Color.MAGENTA);
				g2D.drawArc(x2, (int) (y2-ArcWidth/2), x1-x2,ArcWidth, 0, 25);

			}
			else
			{
				g2D.drawLine(x2,y2,x2+5,(int)(y2+5*slope));
				g2D.setColor(Color.MAGENTA);
				g2D.drawLine(x1, y1, x1-5,(int) (y1-5*slope));
			}
		}
		
		
		
	}
}
	for(int i = 0;i<myGrid.getRows();i++)
	{
		for(int j=0;j<myGrid.getColumns();j++)
		{
			g2D.setColor(Color.BLACK);
			 Font font = new Font("Verdana", Font.BOLD, squareSize/2);
			g2D.setFont(font);
			g2D.drawString(String.valueOf(myGrid.getElement(i, j)+1),25+squareSize*j,50+squareSize*i+3*squareSize/4);
			g2D.setColor(Color.BLACK);
			 Font font1 = new Font("Verdana",Font.ITALIC, squareSize/4);
			g2D.setFont(font1);
			g2D.drawString(String.valueOf(solved.getElement(i, j)+1),25+squareSize*j,25+squareSize*i+squareSize/4);
		}
	}
	
		if(myGrid.isSolved()&&MovesPerformed!=0)
		{
			g2D.setColor(Color.BLACK);
			g2D.drawString("YOU SOLVED IT in "+MovesPerformed+" moves!",50, 25+squareSize*numRows+60);
			MovesPerformed=0;
		}
}

public void actionPerformed(ActionEvent e) {
	/*
	 * this is for all the events that can occur during a game.  This includes the buttons.  It telss you what variables
	 * change when each button is pressed, and what should be done.
	 */
	repaint();
	if(e.getSource()==ExecuteButton)
	{
		doExecute=true;
	}
	if(e.getSource()==scramble)
	{
		int ScrambleLength = (int)(Math.random()*10000);
		for(int i = 0;i<ScrambleLength;i++)
		{	
			
			int move = (int) (Math.random()*numMoves);
			myGrid.doFunction(myMoves[move].getfunction());
			
			
		}
	}
	if(e.getSource()==solve)
	{
		myGrid.makeSolved();
		MovesPerformed=0;
	}
	for(int i = 0;i<Moves.length;i++)
	{
		if(e.getSource()==Moves[i])
		{
			selectedMove=i;
		}
	}
	repaint();

}

}
