
public class FileInfo {
	int diskNumber;
	int startingSector;
	int fileLength;
	
	FileInfo(int DiskNumber, int StartingSector, int FileLength)
	{
		diskNumber = DiskNumber;
		startingSector = StartingSector;
		fileLength = FileLength;
	}
}
