package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> read() throws IOException;
}
