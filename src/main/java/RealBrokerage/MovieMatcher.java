package RealBrokerage;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MovieMatcher {

    static class Movie {
        int id;
        String title;
        int year;

        Movie(int id, String title, int year) {
            this.id = id;
            this.title = title.toLowerCase().trim();
            this.year = year;
        }
    }

    static class ActorDirector {
        int movieId;
        String name;
        String role;

        ActorDirector(int movieId, String name, String role) {
            this.movieId = movieId;
            this.name = name.toLowerCase().trim();
            this.role = role.toLowerCase().trim();
        }
    }

    static class ProviderMovie {
        String mediaId;
        String title;
        int year;
        String actors;
        String director;
        String url;

        ProviderMovie(String mediaId, String title, int year, String actors, String director, String url) {
            this.mediaId = mediaId;
            this.title = title.toLowerCase().trim();
            this.year = year;
            this.actors = actors.toLowerCase().trim();
            this.director = director.toLowerCase().trim();
            this.url = url;
        }
    }

    public static void main(String[] args) throws IOException, CsvException {
        List<Movie> movies = loadMovies("movies.csv");
        List<ActorDirector> actorsDirectors = loadActorsDirectors("actors_and_directors.csv");
        List<ProviderMovie> providerMovies = loadProviderMovies("xbox.csv");

        Map<Integer, Set<String>> movieActors = new HashMap<>();
        Map<Integer, String> movieDirectors = new HashMap<>();

        for (ActorDirector ad : actorsDirectors) {
            if (ad.role.equals("cast")) {
                movieActors.computeIfAbsent(ad.movieId, k -> new HashSet<>()).add(ad.name);
            } else if (ad.role.equals("director")) {
                movieDirectors.put(ad.movieId, ad.name);
            }
        }

        Map<String, Integer> matchedMovies = new HashMap<>();
        for (ProviderMovie providerMovie : providerMovies) {
            Integer matchedId = findMatch(providerMovie, movies, movieActors, movieDirectors);
            if (matchedId != null) {
                matchedMovies.put(providerMovie.mediaId, matchedId);
            }
        }

        // Output the results
        matchedMovies.forEach((mediaId, movieId) -> System.out.println("Media ID: " + mediaId + ", Movie ID: " + movieId));
    }

    private static List<Movie> loadMovies(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\deepa\\Downloads\\FirstGitProject\\src\\main\\resources\\movies.csv"))) {
            return reader.readAll().stream().skip(1).map(data -> new Movie(
                    Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]))).collect(Collectors.toList());
        }
    }

    private static List<ActorDirector> loadActorsDirectors(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\deepa\\Downloads\\FirstGitProject\\src\\main\\resources\\actors_and_directors.csv"))) {
            return reader.readAll().stream().skip(1).map(data -> new ActorDirector(
                    Integer.parseInt(data[0]), data[1], data[2])).collect(Collectors.toList());
        }
    }

    private static List<ProviderMovie> loadProviderMovies(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\deepa\\Downloads\\FirstGitProject\\src\\main\\resources\\xbox_feed.csv"))) {
            return reader.readAll().stream().skip(1).map(data -> new ProviderMovie(
                    data[0], data[1], Integer.parseInt(data[2]), data[4], data[5], data[6])).collect(Collectors.toList());
        }
    }

    private static Integer findMatch(ProviderMovie providerMovie, List<Movie> movies,
                                     Map<Integer, Set<String>> movieActors, Map<Integer, String> movieDirectors) {
        List<Movie> possibleMatches = movies.stream()
                .filter(movie -> movie.title.equals(providerMovie.title) && movie.year == providerMovie.year)
                .collect(Collectors.toList());

        Set<String> providerActors = new HashSet<>(Arrays.asList(providerMovie.actors.split(", ")));

        for (Movie movie : possibleMatches) {
            Set<String> actors = movieActors.get(movie.id);
            String director = movieDirectors.get(movie.id);

            if ((actors != null && !Collections.disjoint(actors, providerActors)) ||
                    (director != null && director.equals(providerMovie.director))) {
                return movie.id;
            }
        }
        return null;
    }
}
