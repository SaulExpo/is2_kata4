package es.ulpgc.view;

import es.ulpgc.model.Title;

import javax.swing.*;

public class JFreeChartTitleDisplay extends JPanel implements TitleDisplay {

    private final JLabel label;

    public JFreeChartTitleDisplay(){
        this.add(label = createLabel());
    }

    private JLabel createLabel() {
        return new JLabel();
    }

    @Override
    public void show(Title title){
        label.setText(title.primaryTitle() + " " + title.titleType());
    }
}
