package code.lowleveldesign.inmemoryfilesystem.spacemanagement;

import code.lowleveldesign.inmemoryfilesystem.exceptions.NoSpaceAvailable;

public interface FreeChunckProvider {
    public ChunckInfo getNextFreeChunck() throws NoSpaceAvailable;
    public boolean addFreeChunck(ChunckInfo spaceInfo);
}
