package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;

import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.filestorage.FileSystem;
import code.lowleveldesign.inmemoryfilesystem.filestorage.StorageManager;

public class InMemoryFileSystem implements FileSystem {

    private static final int SIZE = 100;
    private StorageManager storageManager;

    public InMemoryFileSystem() {
        this.storageManager = new InMemoryStorageManager(SIZE);
    }

    @Override
    public String createFile(String fileName, char[] arr) {
        File file = new File(fileName, arr);

        return null;
    }

    @Override
    public char[] readFile(String fileName) {
        return new char[0];
    }

    @Override
    public boolean updateFile(String fileName, char[] arr) {
        return false;
    }

    @Override
    public void deleteFile(String fileName) {

    }
}
