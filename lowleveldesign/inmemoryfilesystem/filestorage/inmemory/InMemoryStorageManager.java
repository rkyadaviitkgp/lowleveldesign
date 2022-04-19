package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;
import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.filestorage.StorageManager;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.FreeChunckProvider;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryFreeChunckProvider;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryChunckInfo;


public class InMemoryStorageManager implements StorageManager {


    FreeChunckProvider freeSpaceProvider;
    InMemoryLowLevelStorage inMemoryLowLevelStorage;

    public InMemoryStorageManager(int size) {
        InMemoryChunckInfo inMemorySpaceInfo = new InMemoryChunckInfo(0, size-1);
        freeSpaceProvider = new InMemoryFreeChunckProvider(inMemorySpaceInfo);
        inMemoryLowLevelStorage = new InMemoryLowLevelStorage(size);
    }

    @Override
    public boolean save(File file) {
        return false;
    }

    @Override
    public boolean delete(File file) {
        return false;
    }

    @Override
    public boolean read(File File) {
        return false;
    }

}
