package Database;

public class DBMovieHandler {
    private DBMovie DBMovie;
    public DBMovieHandler() {
        this.DBMovie = DBMovie;
    }
    public DBMovie getMovie() {
        return DBMovie;
    }
    public void setMovie(DBMovie DBMovie) {
        this.DBMovie = DBMovie;
    }
}