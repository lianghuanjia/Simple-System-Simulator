import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.scene.paint.Color;


public class UserThread extends Thread{
	private StringBuffer localsb;
	private String USERi;
	private String userName;

	UserThread(String fileName, String UserName)
	{
		USERi = fileName;
		userName = UserName;
	}


	public void run() //Note: the run must be public visibility.
	{
		try 
		{
			File file = new File(USERi);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				String eachLine = scan.nextLine();
				
				if(eachLine.startsWith(".save"))
				{
					String[] split_command = eachLine.split("\\s+"); 
					int avai_index = OS.diskManager.request();
					Platform.runLater(new Runnable() {
						public void run() {
							
							if (userName.equals("User 1")) {
								GUI.ucircle1.setFill(Color.LIGHTSALMON);
								GUI.utext1.setText("Save " + split_command[1] + "\nto Disk " + Integer.toString(avai_index));
							}
							else if (userName.equals("User 2")) {
								GUI.ucircle2.setFill(Color.LIGHTSALMON);
								GUI.utext2.setText("Save " + split_command[1] + "\nto Disk " + Integer.toString(avai_index));
							}
							else if (userName.equals("User 3")) {
								GUI.ucircle3.setFill(Color.LIGHTSALMON);
								GUI.utext3.setText("Save " + split_command[1] + "\nto Disk " + Integer.toString(avai_index));
							}
							else if (userName.equals("User 4")) {
								GUI.ucircle4.setFill(Color.LIGHTSALMON);
								GUI.utext4.setText("Save " + split_command[1] + "\nto Disk " + Integer.toString(avai_index));
							}
							else {
								System.out.println("No matching user");
							}
						}
					});
					int initialSector = OS.disk_list[avai_index].get_freeSector();
					System.out.println(userName + " wants to save " + split_command[1] + " file to Disk " + Integer.toString(avai_index));
					String target_file = split_command[1];
					String writing_stuff = scan.nextLine();
					int line_count = 0;
					while(scan.hasNextLine()&& !(writing_stuff.startsWith(".end")))
					{
						try 
						{	
							int targetSector = OS.disk_list[avai_index].get_freeSector();
							localsb = new StringBuffer(writing_stuff);
							System.out.println("Disk " + Integer.toString(avai_index) + " is writing " + localsb);
							OS.disk_list[avai_index].write(targetSector, localsb, target_file);
							Thread.sleep(200);
							line_count++;
							writing_stuff = scan.nextLine();
						}
						catch(InterruptedException e)
						{
							System.out.println("Thread Interrupted");
						}
					}
					OS.diskManager.release(avai_index);
					FileInfo fileInfo = new FileInfo(avai_index, initialSector, line_count);
					OS.directoryManager.enter(target_file, fileInfo);
					reset_color();
					reset_text();
					
				}
				else if (eachLine.startsWith(".end"))
				{
					System.out.println(".end");
				}
				else if (eachLine.startsWith(".print"))
				{
					String[] print_targetfile = eachLine.split("\\s+");
					PrintJobThread printThread = new PrintJobThread(userName, print_targetfile[1]);	
					Thread pThread = new Thread(printThread);
					pThread.start();
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e)
			{
			System.out.println("File not found");
			}
	}
	
	public void reset_color()
	{
		GUI.ucircle1.setFill(Color.LIGHTSKYBLUE);
		GUI.ucircle2.setFill(Color.LIGHTSKYBLUE);
		GUI.ucircle3.setFill(Color.LIGHTSKYBLUE);
		GUI.ucircle4.setFill(Color.LIGHTSKYBLUE);
	}
	
	public void reset_text()
	{
		GUI.utext1.setText("User 1");
		GUI.utext2.setText("User 2");
		GUI.utext3.setText("User 3");
		GUI.utext4.setText("User 4");
	}
	
}
