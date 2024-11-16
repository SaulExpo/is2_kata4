package es.ulpgc;

import es.ulpgc.control.*;
import es.ulpgc.model.Histogram;
import es.ulpgc.view.MainFrame;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File tsvFile = new File(args[0]);
        File dbFile = new File(args[1]);
        new TitleLoader().loadTitles(tsvFile, dbFile);
        MainFrame mainFrame = new MainFrame();
        Histogram histogram = new TitleTypeHistogram(new SQLiteTitleReader(dbFile));
        mainFrame.displayhistogram(histogram);
        mainFrame.setVisible(true);
    }
}
