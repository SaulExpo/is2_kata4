package model;

import java.util.List;

public interface Histogram {

    public List<String> keys();
    int valueOf(String key);
    String title();
}
