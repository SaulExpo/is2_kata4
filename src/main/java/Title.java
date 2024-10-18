import java.time.Year;
import java.util.List;

public record Title(String id, Title.TitleType titleType, String primaryTitle, String originalTitle, boolean isAdult,
                    Year startYear, Year endYear, Integer runtimeMinutes, List<Genres> genres) {

    public enum TitleType {
        VIDEOGAME,
        TVPILOT,
        MOVIE,
        TVSERIES,
        TVMINISERIES,
        SHORT,
        TVSPECIAL,
        TVSHORT,
        VIDEO,
        TVMOVIE,
        TVEPISODE
    }

    public enum Genres{
        Action,
        Adult,
        Adventure,
        Animation,
        Biography,
        Comedy,
        Crime,
        Documentary,
        Drama,
        Family,
        Fantasy,
        Film_Noir,
        Game_Show,
        History,
        Horror,
        Music,
        Musical,
        Mystery,
        News,
        Reality_TV,
        Romance,
        Sci_Fi,
        Short,
        Sport,
        Talk_Show,
        Thriller,
        War,
        Western
    }
}
