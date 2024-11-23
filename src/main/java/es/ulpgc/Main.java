package es.ulpgc;

import es.ulpgc.control.*;
import es.ulpgc.model.Histogram;
import es.ulpgc.view.MainFrame;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File tsvFile = new File("./title.basics.tsv");
        File dbFile = new File("./base_de_datos.db");
        new TitleLoader().loadTitles(tsvFile, dbFile);
        MainFrame mainFrame = new MainFrame();
        Histogram histogram = new TitleTypeHistogram(new SQLiteTitleReader(dbFile));
        mainFrame.displayhistogram(histogram);
        Command randomCommand = new SQLiteRandomCommand(
                mainFrame.titleDisplay(),
                dbFile
        );
        mainFrame.add("random", randomCommand);
        mainFrame.setVisible(true);
    }
}
