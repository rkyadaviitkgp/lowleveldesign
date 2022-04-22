package code.lowleveldesign.inmemoryfilesystem.filestorage;

import java.util.Arrays;

public class FileSystemManager {

    FileSystem fileSystem;

    public FileSystemManager(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String createFile(String fileName, char arr[]){
        String name =  fileSystem.createFile(fileName, arr);
        System.out.println("New file is created with name " + name);
        return name;
    }

    public char[] readFile(String fileName){
        char arr[] = fileSystem.readFile(fileName);
        System.out.println("File content for file " + fileName + " is " + Arrays.toString(arr));
        return arr;
    }

    public boolean updateFile(String fileName, char arr[]){
        boolean ans = fileSystem.updateFile(fileName, arr);
        if(ans)
            System.out.println("File " + fileName + " content updated successfully");
        else
            System.out.println("Can not update file");
        return ans;
    }

    public void deleteFile(String fileName){
        fileSystem.deleteFile(fileName);
        System.out.println("File deleted successfully");
    }

}
