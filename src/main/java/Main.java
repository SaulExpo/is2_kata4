import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader reader = new TsvTitleReader(new File("./title.basics.tsv"));
        List<Title> titles = reader.read();
        Map<Title.TitleType, Integer> histogram = createHistogram(titles);
        for (Title.TitleType type :histogram.keySet()){
            System.out.println(type + ": " + histogram.get(type));
        }
    }
}
