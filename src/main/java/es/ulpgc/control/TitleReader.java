package es.ulpgc.control;

import es.ulpgc.model.Title;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public interface TitleReader {
    Iterator<Title> read() throws IOException;
}
