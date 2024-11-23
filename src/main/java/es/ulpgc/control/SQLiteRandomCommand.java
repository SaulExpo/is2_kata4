package es.ulpgc.control;

import es.ulpgc.model.Title;
import es.ulpgc.persistance.RandomTitleLoader;
import es.ulpgc.persistance.SQLiteRandomTItleLoader;
import es.ulpgc.view.TitleDisplay;

import java.io.File;

public class SQLiteRandomCommand implements Command{
    private final TitleDisplay titleDisplay;
    private final File dbfile;
    public SQLiteRandomCommand(TitleDisplay titleDisplay, File dbfile){
        this.titleDisplay = titleDisplay;
        this.dbfile = dbfile;
    }

    @Override
    public void execute() {
        RandomTitleLoader loader = new SQLiteRandomTItleLoader(this.dbfile);
        Title title = loader.load();
        titleDisplay.show(title);
    }
}
