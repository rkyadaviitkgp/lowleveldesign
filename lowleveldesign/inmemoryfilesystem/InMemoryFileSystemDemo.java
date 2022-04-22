package code.lowleveldesign.inmemoryfilesystem;

import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.filestorage.FileSystemManager;
import code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory.InMemoryFileSystem;

public class InMemoryFileSystemDemo {

    public static void main(String[] args) {

        InMemoryFileSystem inMemoryFileSystem = new InMemoryFileSystem();
        FileSystemManager fileSystemManager = new FileSystemManager(inMemoryFileSystem);
        char filecontent[] = {'a', 'b', 'c', 'd'};
        char filecontent1[] = {'e', 'f', 'g', 'h', 'x', 'y', 'z'};
        char filecontenet2[] = {'i', 'j', 'k', 'l', 'm', 'n'};
        fileSystemManager.createFile("file1", filecontent);
        fileSystemManager.createFile("file2", filecontent1);
        fileSystemManager.deleteFile("file1");
        fileSystemManager.createFile("file3", filecontenet2);
        fileSystemManager.deleteFile("file2");
//        fileSystemManager.readFile("file1");
//        fileSystemManager.readFile("file2");
        fileSystemManager.readFile("file3");

    }
}
