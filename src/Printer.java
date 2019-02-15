import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.paint.Color;

public class Printer {
	private BufferedWriter bw;
	private int pNO;
	
	Printer(int serialNumber)
	{
		try
		{
			File file = new File("PRINTER"+ Integer.toString(serialNumber));
			FileWriter fileWriter = new FileWriter(file);
			bw = new BufferedWriter(fileWriter);
			pNO = serialNumber;
		}
		catch(IOException e)
		{
			System.out.println("IO exception during creating BufferedWriter");
		}
	}
	
	
	void write(StringBuffer writingContent, String file) 
	{
		try 
		{	
			
			bw.write(writingContent.toString());
			bw.flush();

		}
		catch(IOException e)
		{
			System.out.println("IO exception during writing");
		}
	}
	
}
