import javax.swing.*;

public class MainFrame extends JFrame {

    HistogramDisplay display;

    public MainFrame(){
        this.setTitle("model.model.Histogram Display");
        this.setSize(1800, 1600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.display = new JFreeChartHistogramDisplay();
        add((JPanel)display);
    }


    public void displayhistogram(Histogram histogram) {
        display.display(histogram);
    }
}
