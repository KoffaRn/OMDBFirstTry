import Database.DBActor;
import Database.DBMovie;

import java.util.Scanner;

public class ConsoleInterface {
    boolean running = true;
    MovieHandler movieHandler;
    public ConsoleInterface() {
        this.movieHandler = new MovieHandler();
    }
    public boolean getRunning() {
        return running;
    }
    public void printMenu() {
        System.out.println("1. Search for a movie");
        System.out.println("2. Search for an actor");
        System.out.println("3. Search for a director");
        System.out.println("4. Search for a writer");
        System.out.println("5. Exit");
        switch(takeIntInput(1,5)) {
            case 1:
                System.out.println("Enter a movie title ");
                searchMovie();
                break;
            case 2:
                getActor("ACTOR");
                break;
            case 3:
                getActor("DIRECTOR");
                break;
            case 4:
                getActor("WRITER");
                break;
            case 5:
                running = false;
                break;
        }
    }
    private void getActor(String role) {
        System.out.println("Enter " + role + " name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        DBActor result = movieHandler.getDBActors(name, role);
        if(result == null) {
            System.out.println("No results found");
        } else {
            System.out.println("Names: " + result.getName());
            DBMovie[] movies = movieHandler.getActorsMovies(result, role);
            System.out.println("Movies: " + movies.length);
            for (int i = 0; i < movies.length; i++) {
                System.out.println(movies[i].getTitle());
            }
        }
    }
    private void searchMovie() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Search for movie: " + input);
        DBMovie[] result = movieHandler.getDBMovies(input);
        if(result == null) {
            System.out.println("No results found");
        } else {
            System.out.println("Found " + result.length + " results");
            System.out.println("Enter a number to see more info about the movie");
            for (int i = 0; i < result.length; i++) {
                System.out.println(i + ". " + result[i].getTitle());
            }
            int choice = takeIntInput(0, result.length - 1);
            DBMovie movie = movieHandler.getMovie(result[choice].getImdbID());
            System.out.println(movie);
        }
    }
    private int takeIntInput(int min, int max) {
        Scanner sc = new Scanner(System.in);
        try {
            int input = sc.nextInt();
            if(input > max || input < min) {
                System.out.println("Invalid input");
                return takeIntInput(max, min);
            } else {
                return input;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            return takeIntInput(max, min);
        }
    }
}
