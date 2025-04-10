import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Usage {
    public Usage() {
        try {
            String extentFile = "plik.ser";
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Movie.writeExtent(out);
            out.close();

            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Movie.readExtent(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Movie implements Serializable {
    private static List<Movie> extent = new ArrayList<>();

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Movie>) stream.readObject();
    }
}