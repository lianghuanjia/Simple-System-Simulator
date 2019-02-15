import javafx.scene.paint.Color;

public class PrintJobThread extends Thread{
	private String target_file;
	private String userName;
	
	PrintJobThread(String UserName, String fileName)
	{
		userName = UserName;
		target_file = fileName;	
	}
	
	public void run()
	{
		int avai_index = OS.printerManager.request();
		System.out.println(userName + " wants to print " + target_file);
		FileInfo file_info = OS.directoryManager.lookup(target_file);
		try 
		{
			for(int i = 0; i < file_info.fileLength; i++)
			{
				StringBuffer data = new StringBuffer();
				OS.disk_list[file_info.diskNumber].read(file_info.startingSector+i, data, target_file);
				Thread.sleep(200);
				OS.printer_list[avai_index].write(data.append("\n"),target_file);
				System.out.println("Printer " + avai_index + " is printing " + target_file);
				Thread.sleep(2750);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread interrupted.");
		}
		OS.printerManager.release(avai_index);
		
	}

}
