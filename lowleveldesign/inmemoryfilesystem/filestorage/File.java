package code.lowleveldesign.inmemoryfilesystem.filestorage;

public class File {

    String fileName;
    char content[];

    public File(String fileName, char[] content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public char[] getContent() {
        return content;
    }

    public void setContent(char[] content) {
        this.content = content;
    }
}
