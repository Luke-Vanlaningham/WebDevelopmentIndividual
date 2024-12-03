package myPack;
import java.lang.Math;
import java.util.Scanner;
public class Main {
public static void main(String args[])
{
	String[] alphabet = new String[24];
	alphabet[0]="A";
	alphabet[1]="B";
	alphabet[2]="C";
	alphabet[3]="D";
	alphabet[4]="E";
	alphabet[5]="F";
	alphabet[6]="G";
	alphabet[7]="H";
	alphabet[8]="I";
	alphabet[9]="J";
	alphabet[10]="K";
	alphabet[11]="L";
	alphabet[12]="M";
	alphabet[13]="N";
	alphabet[14]="O";
	alphabet[15]="P";
	alphabet[16]="SH";
	alphabet[17]="R";
	alphabet[18]="S";
	alphabet[19]="T";
	alphabet[20]="U";
	alphabet[21]="V";
	alphabet[22]="W";
	alphabet[23]="CH";
	Scanner scnr = new Scanner(System.in);
	System.out.println("how long for each string?");
	int lengthOfString = scnr.nextInt();
	System.out.println("how many Strings?");
	int numStrings = scnr.nextInt();
	for(int j = 1;j<=numStrings;j++)
	{
	String randString = "";
	for(int i = 0;i<lengthOfString;i++)
	{
		int myRandom = (int) (Math.random()*24);
		String randomLetter = alphabet[myRandom];
		randString+=randomLetter;
		if(i%2==1)
		{
			randString+=" ";
		}
	}
	System.out.println("String "+j+": "+randString);
	}
}
}
