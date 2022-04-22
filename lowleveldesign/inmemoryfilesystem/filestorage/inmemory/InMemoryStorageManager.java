package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;
import code.lowleveldesign.inmemoryfilesystem.exceptions.NoSpaceAvailable;
import code.lowleveldesign.inmemoryfilesystem.filestorage.File;
import code.lowleveldesign.inmemoryfilesystem.filestorage.StorageManager;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.FreeChunckProvider;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryFreeChunckProvider;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryChunckInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InMemoryStorageManager implements StorageManager {

    FreeChunckProvider freeSpaceProvider;
    InMemoryLowLevelStorage inMemoryLowLevelStorage;
    HashMap<String, ArrayList<InMemoryChunckInfo>> fileStorageInfo;
    static int counter = 0;
    private static final int COMPACT_ITERATION = 25;

    public InMemoryStorageManager(int size) {
        InMemoryChunckInfo inMemorySpaceInfo = new InMemoryChunckInfo(0, size-1);
        freeSpaceProvider = new InMemoryFreeChunckProvider(inMemorySpaceInfo);
        inMemoryLowLevelStorage = new InMemoryLowLevelStorage(size);
        fileStorageInfo = new HashMap<>();
    }

    @Override
    public boolean save(File file) {

        counter++;
        if(counter%COMPACT_ITERATION == 0)
            freeSpaceProvider.compactFreeChunk();

        String fileName = file.getFileName();
        char content[] = file.getContent();
        int index = 0;
        while(index < content.length){
            try{
                InMemoryChunckInfo inMemoryChunckInfo = (InMemoryChunckInfo) freeSpaceProvider.getNextFreeChunck();
                if(inMemoryChunckInfo.getEndIndex()-inMemoryChunckInfo.getStartIndex() + 1 + index > content.length){
                    int len = content.length - index;
                    InMemoryChunckInfo newInmemoryChunkInfo =  inMemoryChunckInfo.splitChunk(len);
                    freeSpaceProvider.addFreeChunck(newInmemoryChunkInfo);
                }
                if(!fileStorageInfo.containsKey(fileName))
                    fileStorageInfo.put(fileName, new ArrayList<InMemoryChunckInfo>());
                fileStorageInfo.get(fileName).add(inMemoryChunckInfo);
                inMemoryLowLevelStorage.putInMemory(content, index, inMemoryChunckInfo);
                index = index + inMemoryChunckInfo.getEndIndex()-inMemoryChunckInfo.getStartIndex() + 1;
            }catch (NoSpaceAvailable noSpaceAvailable){
                System.out.println(noSpaceAvailable.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(String fileName) {
        ArrayList<InMemoryChunckInfo> list = fileStorageInfo.get(fileName);
        for(InMemoryChunckInfo inMemoryChunckInfo : list){
            inMemoryLowLevelStorage.deleteContent(inMemoryChunckInfo);
            freeSpaceProvider.addFreeChunck(inMemoryChunckInfo);
        }
        fileStorageInfo.remove(fileName);
        return true;
    }

    @Override
    public List<Character> read(String fileName) {
        List<Character> fileContent = new ArrayList<>();
        ArrayList<InMemoryChunckInfo> list = fileStorageInfo.get(fileName);
        for(InMemoryChunckInfo inMemoryChunckInfo : list){
            fileContent.addAll(inMemoryLowLevelStorage.readContent(inMemoryChunckInfo));
        }
        return fileContent;
    }

}
