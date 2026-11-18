package com.example.controller;

import java.util.List;
import java.util.function.Consumer;

import com.example.components.CustomControl;
import com.example.components.MovieCard;
import com.example.data.MovieData;
import com.example.model.Movie;
import com.example.service.SoundService;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class HomeController {
    private final BorderPane root;
    private final Consumer<Movie> onMovieSelected;
    private final Runnable onShowWatchlist;
    private VBox mainContent;
    private ScaleTransition bannerZoom;

    public HomeController(Consumer<Movie> onMovieSelected, Runnable onShowWatchlist) {
        this.onMovieSelected = onMovieSelected;
        this.onShowWatchlist = onShowWatchlist;
        root = new BorderPane();
        root.setStyle("-fx-background-color: #101010;");

        root.setTop(buildNavBar());
        mainContent = new VBox(30);
        mainContent.setStyle("-fx-padding: 20; -fx-background-color: #101010;");

        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #101010; -fx-background-color: #101010;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        root.setCenter(scrollPane);
        showHomeContent();
    }

    private HBox buildNavBar() {
        HBox navBar = new HBox(25);
        navBar.setAlignment(Pos.CENTER_LEFT);
        navBar.setStyle("-fx-padding: 15 20; -fx-background-color: #181818;");

        Label logo = new Label("CINEMAX");
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        logo.setTextFill(Color.web("#E50914"));

        CustomControl homeBtn = new CustomControl("⌂  Home", 16, Color.WHITE, Color.web("#E50914"));
        homeBtn.setOnAction(this::showHomeContent);

        CustomControl moviesBtn = new CustomControl("▶  Movies", 16, Color.WHITE, Color.web("#E50914"));
        moviesBtn.setOnAction(this::showMoviesContent);

        CustomControl tvBtn = new CustomControl("🖵  TV Shows", 16, Color.WHITE, Color.web("#E50914"));
        tvBtn.setOnAction(this::showTvShowsContent);

        CustomControl myListBtn = new CustomControl("♥  My List", 16, Color.WHITE, Color.web("#E50914"));
        myListBtn.setOnAction(() -> { SoundService.playNav(); onShowWatchlist.run(); });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox searchContainer = new HBox(8);
        searchContainer.setAlignment(Pos.CENTER);
        searchContainer.setStyle("-fx-background-color: #333; -fx-background-radius: 20; -fx-padding: 6 15;");
        
        Label searchIcon = new Label("⌕"); 
        searchIcon.setFont(Font.font("Segoe UI Symbol", 16));
        searchIcon.setTextFill(Color.GRAY);

        TextField searchField = new TextField();
        searchField.setPromptText("Search title, genre, year...");
        searchField.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: gray;");
        searchField.setPrefWidth(220);
        
        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.isEmpty()) showHomeContent();
            else showSearchResults(newVal);
        });

        searchContainer.getChildren().addAll(searchIcon, searchField);

        CustomControl profileIcon = new CustomControl("●", 22, Color.WHITE, Color.web("#E50914"));

        navBar.getChildren().addAll(logo, homeBtn, moviesBtn, tvBtn, myListBtn, spacer, searchContainer, profileIcon);
        return navBar;
    }

    private void showHomeContent() {
        mainContent.getChildren().clear();
        Movie featured = MovieData.getActionMovies().get(0);
        
        StackPane featuredPane = new StackPane();
        featuredPane.setMinHeight(400);
        featuredPane.setStyle("-fx-background-color: #1a1a1a; -fx-background-radius: 12;");
        VBox.setVgrow(featuredPane, Priority.ALWAYS);

        ImageView backdrop = new ImageView();
        try { backdrop.setImage(new Image(featured.getPosterUrl(), true)); } catch (Exception ignored) {}
        
        backdrop.fitWidthProperty().bind(featuredPane.widthProperty());
        backdrop.setFitHeight(400);
        backdrop.setPreserveRatio(false);
        backdrop.setOpacity(0.4);

        // ENHANCEMENT #1: Moving Background Banner
        bannerZoom = new ScaleTransition(Duration.seconds(20), backdrop);
        bannerZoom.setFromX(1.0);
        bannerZoom.setFromY(1.0);
        bannerZoom.setToX(1.15);
        bannerZoom.setToY(1.15);
        bannerZoom.setCycleCount(Timeline.INDEFINITE);
        bannerZoom.setAutoReverse(true);
        bannerZoom.setInterpolator(Interpolator.EASE_BOTH);
        bannerZoom.play();

        VBox featuredInfo = new VBox(10);
        featuredInfo.setAlignment(Pos.CENTER_LEFT);
        featuredInfo.setPadding(new Insets(40));
        featuredInfo.setMaxWidth(Double.MAX_VALUE); 

        Label featuredTitle = new Label(featured.getTitle());
        featuredTitle.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        featuredTitle.setTextFill(Color.WHITE);

        Label featuredDesc = new Label(featured.getDescription());
        featuredDesc.setFont(Font.font("Arial", 16));
        featuredDesc.setTextFill(Color.LIGHTGRAY);
        featuredDesc.setWrapText(true);
        featuredDesc.setMaxWidth(600);

        Label meta = new Label(featured.getGenre() + " • " + featured.getYear());
        meta.setFont(Font.font("Arial", 14));
        meta.setTextFill(Color.GRAY);

        HBox buttons = new HBox(15);
        
        CustomControl playBtn = new CustomControl("PLAY TRAILER", 18, Color.BLACK, Color.BLACK);
        playBtn.getLabel().setFont(Font.font("Arial", FontWeight.BOLD, 18)); 
        playBtn.setStyle("-fx-background-color: white; -fx-background-radius: 5; -fx-padding: 10 20; -fx-cursor: hand;");
        playBtn.setOnAction(() -> onMovieSelected.accept(featured));

        CustomControl infoBtn = new CustomControl("MORE INFO", 18, Color.WHITE, Color.BLACK);
        infoBtn.getLabel().setFont(Font.font("Arial", FontWeight.BOLD, 18));
        infoBtn.setStyle("-fx-background-color: rgba(109,109,110,0.7); -fx-background-radius: 5; -fx-padding: 10 20; -fx-cursor: hand;");
        infoBtn.setOnAction(() -> onMovieSelected.accept(featured));

        buttons.getChildren().addAll(playBtn, infoBtn);
        featuredInfo.getChildren().addAll(featuredTitle, meta, featuredDesc, buttons);

        featuredPane.getChildren().addAll(backdrop, featuredInfo);
        StackPane.setAlignment(featuredInfo, Pos.CENTER_LEFT);

        mainContent.getChildren().add(featuredPane);
        mainContent.getChildren().addAll(
                createCategoryRow("Action Movies", MovieData.getActionMovies()),
                createCategoryRow("Comedy Movies", MovieData.getComedyMovies()),
                createCategoryRow("Science Fiction Movies", MovieData.getSciFiMovies()),
                createCategoryRow("Horror Movies", MovieData.getHorrorMovies()),
                createCategoryRow("Drama Movies", MovieData.getDramaMovies())
        );
    }

    private void showMoviesContent() {
        if (bannerZoom != null) bannerZoom.stop();
        mainContent.getChildren().clear();
        Label title = new Label("Movies");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        title.setTextFill(Color.WHITE);
        title.setPadding(new Insets(0, 0, 10, 0));
        mainContent.getChildren().add(title);
        
        mainContent.getChildren().addAll(
                createCategoryRow("Action Movies", MovieData.getActionMovies()),
                createCategoryRow("Comedy Movies", MovieData.getComedyMovies()),
                createCategoryRow("Science Fiction Movies", MovieData.getSciFiMovies()),
                createCategoryRow("Horror Movies", MovieData.getHorrorMovies()),
                createCategoryRow("Drama Movies", MovieData.getDramaMovies())
        );
    }

    private void showTvShowsContent() {
        if (bannerZoom != null) bannerZoom.stop();
        mainContent.getChildren().clear();
        Label title = new Label("TV Shows");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        title.setTextFill(Color.WHITE);
        title.setPadding(new Insets(0, 0, 10, 0));
        mainContent.getChildren().add(title);
        
        mainContent.getChildren().add(
                createCategoryRow("Popular TV Shows", MovieData.getTvShows())
        );
    }

    private VBox createCategoryRow(String title, List<Movie> movies) {
        VBox categoryBox = new VBox(10);
        Label categoryLabel = new Label(title);
        categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        categoryLabel.setTextFill(Color.WHITE);

        HBox row = new HBox(15);
        row.setAlignment(Pos.CENTER_LEFT);
        for (Movie movie : movies) {
            MovieCard card = new MovieCard(movie, () -> onMovieSelected.accept(movie));
            row.getChildren().add(card);
        }

        ScrollPane scrollPane = new ScrollPane(row);
        scrollPane.setFitToHeight(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setPrefHeight(320);

        categoryBox.getChildren().addAll(categoryLabel, scrollPane);
        return categoryBox;
    }

    private void showSearchResults(String query) {
        if (bannerZoom != null) bannerZoom.stop();
        mainContent.getChildren().clear();
        Label searchLabel = new Label("Search Results for: \"" + query + "\"");
        searchLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        searchLabel.setTextFill(Color.WHITE);
        mainContent.getChildren().add(searchLabel);

        // ENHANCEMENT #3: Use the new matchesQuery method
        List<Movie> results = MovieData.getAllMovies().stream()
                .filter(m -> MovieData.matchesQuery(m, query))
                .toList();

        if (results.isEmpty()) {
            Label noResults = new Label("No movies or shows found matching your search.");
            noResults.setFont(Font.font("Arial", 18));
            noResults.setTextFill(Color.GRAY);
            mainContent.getChildren().add(noResults);
        } else {
            FlowPane grid = new FlowPane(15, 15);
            for (Movie movie : results) {
                MovieCard card = new MovieCard(movie, () -> onMovieSelected.accept(movie));
                grid.getChildren().add(card);
            }
            mainContent.getChildren().add(grid);
        }
    }

    public BorderPane getRoot() { return root; }
}