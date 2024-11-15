package es.ulpgc.control;

import es.ulpgc.model.Title;

public interface TitleDeserializer {
    Title deserialize(String value);
}
