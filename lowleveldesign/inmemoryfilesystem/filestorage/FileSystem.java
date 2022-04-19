package code.lowleveldesign.inmemoryfilesystem.filestorage;

public interface FileSystem {
    public String createFile(String fileName, char arr[]);
    public char[] readFile(String fileName);
    public boolean updateFile(String fileName, char arr[]);
    public void deleteFile(String fileName);
}
