package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{
    private final File source;

    public TsvTitleReader(File source) {
        this.source = source;
    }

    @Override
    public List<Title> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        readHeadersWith(reader);
        return readTitlesWith(reader);
    }

    private static List<Title> readTitlesWith(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        while (true){
            String l = reader.readLine();
            if (l == null) break;
            titles.add(new TsvTitleDeserializer().deserialize(l));
        }
        return titles;
    }

    private static void readHeadersWith(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
