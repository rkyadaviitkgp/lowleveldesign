package code.lowleveldesign.inmemoryfilesystem.filestorage;

public interface StorageManager {
    public boolean save(File file);
    public boolean delete(File file);
    public boolean read(File File);
}
