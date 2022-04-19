package code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory;

import code.lowleveldesign.inmemoryfilesystem.exceptions.NoSpaceAvailable;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.FreeChunckProvider;
import code.lowleveldesign.inmemoryfilesystem.spacemanagement.ChunckInfo;
import java.util.PriorityQueue;
import java.util.Queue;

public class InMemoryFreeChunckProvider implements FreeChunckProvider {

    Queue<InMemoryChunckInfo> queue;

    public InMemoryFreeChunckProvider(ChunckInfo spaceInfo) {
        queue = new PriorityQueue<>((q1, q2) -> q1.getStartIndex() - q2.getStartIndex());
        addFreeChunck(spaceInfo);
    }

    @Override
    public ChunckInfo getNextFreeChunck() throws NoSpaceAvailable {
        if(queue.isEmpty())
            throw new NoSpaceAvailable("Memory is not available");
        return queue.poll();
    }

    @Override
    public boolean addFreeChunck(ChunckInfo spaceInfo) {
        InMemoryChunckInfo inMemorySpaceInfo = (InMemoryChunckInfo) spaceInfo;
        queue.add(inMemorySpaceInfo);
        return true;
    }
}
