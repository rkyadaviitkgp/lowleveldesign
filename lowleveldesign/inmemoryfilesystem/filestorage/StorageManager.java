package code.lowleveldesign.inmemoryfilesystem.filestorage;

import java.util.List;

public interface StorageManager {
    public boolean save(File file);
    public boolean delete(String fileName);
    public List<Character> read(String fileName);
}
