package com.example.service;



import com.example.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class WatchlistService {
    private static final List<Movie> watchlist = new ArrayList<>();

    public static boolean addMovie(Movie movie) {
        if (watchlist.stream().noneMatch(m -> m.getTitle().equals(movie.getTitle()))) {
            watchlist.add(movie);
            return true;
        }
        return false;
    }

    public static List<Movie> getWatchlist() {
        return new ArrayList<>(watchlist);
    }

    public static boolean removeMovie(Movie movie) {
        return watchlist.removeIf(m -> m.getTitle().equals(movie.getTitle()));
    }
}