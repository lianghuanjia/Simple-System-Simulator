import javafx.application.Platform;
import javafx.scene.paint.Color;

public class Disk {
	static final int NUM_SECTORS = 1024;
	private StringBuffer sectors[];
	private int freeSector;
	private int diskNO;
	
	Disk(int NO)
	{
		sectors =  new StringBuffer[NUM_SECTORS];
		for (int i = 0; i < sectors.length; ++i)
		{
			sectors[i] = new StringBuffer();
		}
		freeSector = 0;
		diskNO = NO;
	}
	
	void write(int sector, StringBuffer data, String file)
	{
		try
		{
			 
			sectors[sector] = data;
			freeSector++;
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println("Index out of bounds");
		}
			
	}
	
	void read(int sector, StringBuffer data, String file)
	{
		try
		{
			data.append(sectors[sector]);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println("Index out of bounds");
		}	
	}
	
	public int get_freeSector()
	{
		return freeSector;
	}

	
}
