package Database;

import java.util.ArrayList;

public class DBGenre {
    private String name;
    private String imdbId;
    public DBGenre() {

    }
    public DBGenre(String name, String imdbID) {
        this.name = name;
        this.imdbId = imdbID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
