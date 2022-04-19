package code.lowleveldesign.inmemoryfilesystem.spacemanagement.inmemory;

import code.lowleveldesign.inmemoryfilesystem.spacemanagement.ChunckInfo;

public class InMemoryChunckInfo extends ChunckInfo {

    int startIndex;
    int endIndex;

    public InMemoryChunckInfo(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
