package es.ulpgc;

import es.ulpgc.control.TitleReader;
import es.ulpgc.control.TitleTypeHistogram;
import es.ulpgc.control.TsvTitleReader;
import es.ulpgc.model.Histogram;
import es.ulpgc.view.MainFrame;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader reader = new TsvTitleReader(new File(args[0]));
        Histogram histogram = new TitleTypeHistogram(reader.read());
        MainFrame mainFrame = new MainFrame();
        mainFrame.displayhistogram(histogram);
        mainFrame.setVisible(true);
    }
}
