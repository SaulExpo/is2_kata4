package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleDeserializer implements TitleDeserializer{
    @Override
    public Title deserialize(String value) {
        String[] columns = value.split("\t");
        return new Title(columns[0], Title.TitleType.valueOf(columns[1].toUpperCase()), columns[2], columns[3],
                Boolean.parseBoolean(columns[4]), getYear(columns[5]), getYear(columns[6]), getMinutes(columns[7]),
                getGenres(columns[8]));
    }

    public Integer getMinutes(String s){
        if(s.equals("\\N")) return null;
        return Integer.parseInt(s);
    }

    public Year getYear(String s){
        if(s.equals("\\N")) return null;
        return Year.parse(s);
    }

    public List<Title.Genres> getGenres(String s){
        if(s.equals("\\N")) return null;
        s = s.replace("-", "_");
        String[] genres = s.split(",");
        List<Title.Genres> genresList = new ArrayList<>();
        for(String g:genres) genresList.add(Title.Genres.valueOf(g));
        return genresList;
    }
}
