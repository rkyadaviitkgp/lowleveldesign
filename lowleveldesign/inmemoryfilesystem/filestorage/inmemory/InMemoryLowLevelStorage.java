package code.lowleveldesign.inmemoryfilesystem.filestorage.inmemory;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory.InMemoryChunckInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryLowLevelStorage {

    char[] memory;
    int unUsedMemory;

    public InMemoryLowLevelStorage(int size) {
        memory = new char[size];
        unUsedMemory = size;
    }

    public void putInMemory(char content[], int index, InMemoryChunckInfo inMemoryChunckInfo){
        for(int i=inMemoryChunckInfo.getStartIndex(); i<=inMemoryChunckInfo.getEndIndex(); i++){
            if(index < content.length)
                memory[i] = content[index++];
            else
                memory[i] = '\0';
        }
    }

    public List<Character> readContent(InMemoryChunckInfo inMemoryChunckInfo){
        printRawMemory();

        List<Character> ans = new ArrayList<>();
        for(int i=inMemoryChunckInfo.getStartIndex(); i<=inMemoryChunckInfo.getEndIndex(); i++){
           ans.add(memory[i]);
        }
        return ans;
    }

    private void printRawMemory(){
        System.out.println(Arrays.toString(memory));
    }

}
