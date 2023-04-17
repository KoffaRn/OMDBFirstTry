import Database.DBActor;
import Database.DBHandler;
import Database.DBMovieHandler;
import OMDB.OMDBHandler;
import OMDB.OMDBMovie;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler("movies");
        DBMovieHandler movieHandler = new DBMovieHandler();
        OMDBHandler omdbHandler = new OMDBHandler();
        ConsoleInterface consoleInterface = new ConsoleInterface();

        while(consoleInterface.getRunning()) {
            consoleInterface.printMenu();
        }
    }
}