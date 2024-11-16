package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.io.IOException;

public interface TitleWriter {
    void write(Title title) throws IOException;
}
