
public class ResourceManager {
	boolean isFree[];
	ResourceManager(int numberOfItems)
	{
		isFree = new boolean[numberOfItems];
		for (int i = 0; i < numberOfItems; ++i)
		{
			isFree[i] = true;
		}
	}

	synchronized int request()
	{
		while(true)
		{
			try 
			{
				for (int i = 0; i < isFree.length; ++i)
					if (isFree[i])
					{
						isFree[i] = false;
						return i;
					}
				
				this.wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("The thread is interrupted");
			}
		}
	}
	
	synchronized void release(int index)
	{
		isFree[index] = true;
		this.notify();
	}


}
