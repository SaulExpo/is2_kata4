package control;

import model.Histogram;
import model.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleTypeHistogram implements Histogram {
    private final Map<Title.TitleType, Integer> histogram;

    public TitleTypeHistogram(List<Title> titles) {
        histogram = createHistogram(titles);
    }

    @Override
    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (Title.TitleType titleType: histogram.keySet()) keys.add(titleType.name());
        return  keys;
    }

    @Override
    public int valueOf(String key) {
        Title.TitleType titleType = Title.TitleType.valueOf(key);
        return histogram.get(titleType);
    }

    @Override
    public String title() {
        return "model.model.model.Title Types";
    }

    private static Map<Title.TitleType, Integer> createHistogram(List<Title> read) {
        Map<Title.TitleType, Integer> histogram = new HashMap<>();
        read.forEach(t -> {
            histogram.putIfAbsent(t.titleType(), 0);
            histogram.compute(t.titleType(), (tt, i) -> i + 1);
        });
        return histogram;
    }
}
