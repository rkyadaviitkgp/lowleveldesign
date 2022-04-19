package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;

import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.filestorage.FileSystem;
import code.lowleveldesign.inmemoryfilesystem.filestorage.StorageManager;

import java.util.ArrayList;

public class InMemoryFileSystem implements FileSystem {

    private static final int SIZE = 100;
    private StorageManager storageManager;

    public InMemoryFileSystem() {
        this.storageManager = new InMemoryStorageManager(SIZE);
    }

    @Override
    public String createFile(String fileName, char[] arr) {
        File file = new File(fileName, arr);
        storageManager.save(file);
        return file.getFileName();
    }

    @Override
    public char[] readFile(String fileName) {
        ArrayList<Character> content = (ArrayList<Character>) storageManager.read(fileName);
        char arr[] =  new char[content.size()];
        int index = 0;
        for(char c : content){
            arr[index++] = c;
        }
        return arr;
    }

    @Override
    public boolean updateFile(String fileName, char[] arr) {
        deleteFile(fileName);
        createFile(fileName, arr);
        return true;
    }

    @Override
    public void deleteFile(String fileName) {
        storageManager.delete(fileName);
    }
}
