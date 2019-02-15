

public class OS {
	static final int NUMBER_OF_USERS = 4;
	static final int NUMBER_OF_DISKS = 2;
	static final int NUMBER_OF_PRINTERS = 3;
	static Disk[] disk_list ;
	static Printer[] printer_list ;
	static DirectoryManager directoryManager;
	static ResourceManager diskManager;
	static ResourceManager printerManager;
	static GUI gui;
	
	public void run_OS() 
	{	
		
		diskManager = new ResourceManager(NUMBER_OF_DISKS);
		printerManager = new ResourceManager(NUMBER_OF_PRINTERS);
		
		disk_list = new Disk[NUMBER_OF_DISKS];
		for(int i = 0; i < NUMBER_OF_DISKS; ++i)
		{
			disk_list[i] = new Disk(i);
		}
		
		printer_list = new Printer[NUMBER_OF_PRINTERS];
		for(int i = 0; i < NUMBER_OF_PRINTERS; ++i)
		{
			printer_list[i] = new Printer(i);
		}
		directoryManager = new DirectoryManager();
		
		

		UserThread u1 = new UserThread("USER1", "User 1");		
		UserThread u2 = new UserThread("USER2", "User 2");
		UserThread u3 = new UserThread("USER3", "User 3");
		UserThread u4 = new UserThread("USER4", "User 4");
	
		Thread uThread1 = new Thread(u1);
		Thread uThread2 = new Thread(u2);
		Thread uThread3 = new Thread(u3);
		Thread uThread4 = new Thread(u4);
		
		uThread1.start();
		uThread2.start();
		uThread3.start();
		uThread4.start();
		
	}
}
