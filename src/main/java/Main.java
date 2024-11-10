import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader reader = new TsvTitleReader(new File("./title.basics.tsv"));
        Histogram histogram = new TitleTypeHistogram(reader.read());
        MainFrame mainFrame = new MainFrame();
        mainFrame.displayhistogram(histogram);
        mainFrame.setVisible(true);
    }
}
