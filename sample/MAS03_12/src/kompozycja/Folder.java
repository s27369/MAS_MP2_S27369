package kompozycja;

import java.util.ArrayList;
import java.util.List;

public class Folder extends ObjectPlus {
    private final String folderName;
    private final List<File> fileList = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public void addFile(File file) {
        fileList.add(file);
    }

    public void removeFile(File file) {
        if (fileList.contains(file)) {
            fileList.remove(file);
            file.removeFromExtent();
        }
    }

    @Override
    public void removeFromExtent() {
       while (!fileList.isEmpty()) {
           removeFile(fileList.getFirst());
       }

        super.removeFromExtent();
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderName='" + folderName + '\'' +
                ", fileList=" + fileList.stream().map(f -> f.getFileName()).toList() +
                '}';
    }
}
