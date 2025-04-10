package kompozycja;

public class File extends ObjectPlus {
    private String fileName;
    private Folder folder;
    public File(String fileName, Folder folder) {
        this.fileName = fileName;
        this.folder = folder;
        folder.addFile(this);
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void removeFromExtent() {
        if(folder != null) {
            Folder temp = folder;
            folder = null;
            temp.removeFile(this);
        }

        super.removeFromExtent();
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", folder=" + folder +
                '}';
    }
}
