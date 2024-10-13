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
