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
        File file = new File("./title.basics.tsv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        List<Title> titles = new ArrayList<>();
        while (true){
            String l = reader.readLine();
            if (l == null) break;
            String[] columns = l.split("\t");
            titles.add(new Title(columns[0], Title.TitleType.valueOf(columns[0].toUpperCase()), columns[1]));
        }
        Map<Title.TitleType, Integer> histogram = new HashMap<>();
        titles.forEach(t->{
            histogram.putIfAbsent(t.titleType(), 0);
            histogram.compute(t.titleType(), (tt, i)->i+1);
        });
        for (Title.TitleType type :histogram.keySet()){
            System.out.println(type + ": " + histogram.get(type));
        }
    }
}
