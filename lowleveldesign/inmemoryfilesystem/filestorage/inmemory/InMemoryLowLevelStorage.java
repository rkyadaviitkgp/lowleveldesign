package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;

import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryChunckInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryLowLevelStorage {

    char[] memory;
    int unUsedMemory;
    HashMap<String, ArrayList<InMemoryChunckInfo>> fileStorageInfo;

    public InMemoryLowLevelStorage(int size) {
        memory = new char[size];
        unUsedMemory = size;
        fileStorageInfo = new HashMap<>();
    }


}
