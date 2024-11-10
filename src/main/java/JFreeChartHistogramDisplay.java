import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class JFreeChartHistogramDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void display(Histogram histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: histogram.keys()){
            dataset.addValue(histogram.valueOf(key), "Frequency", key);
        }
        JFreeChart barchart = ChartFactory.createBarChart(
                histogram.title(),
                "Categories",
                "Frecuencia",
                dataset
        );

        add(new ChartPanel(barchart));
    }
}
