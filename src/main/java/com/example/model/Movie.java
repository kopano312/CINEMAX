package com.example.model;

public class Movie {
    private final String title;
    private final String genre;
    private final int year;
    private final String youtubeVideoId;
    private final String posterUrl;
    private final String description;

    public Movie(String title, String genre, int year, String youtubeVideoId,
                 String posterUrl, String description) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.youtubeVideoId = youtubeVideoId;
        this.posterUrl = posterUrl;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public String getYoutubeVideoId() { return youtubeVideoId; }
    public String getPosterUrl() { return posterUrl; }
    public String getDescription() { return description; }
}