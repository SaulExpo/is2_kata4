public record Title(String id, Title.TitleType titleType, String primaryTitle) {

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
}
