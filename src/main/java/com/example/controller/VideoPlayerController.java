package com.example.controller;

import com.example.components.CustomControl;
import com.example.model.Movie;
import com.example.service.SoundService;
import com.example.service.WatchlistService;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class VideoPlayerController {
    private final BorderPane root;

    public VideoPlayerController(Movie movie, Runnable onBack) {
        root = new BorderPane();
        root.setStyle("-fx-background-color: #101010;");
        
        // ENHANCEMENT #1: Smooth Screen Transition Fade
        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        HBox topBar = new HBox(15);
        topBar.setStyle("-fx-padding: 15 20; -fx-background-color: #181818;");
        topBar.setAlignment(Pos.CENTER_LEFT);

        CustomControl backControl = new CustomControl("←  Back", 16, Color.WHITE, Color.web("#E50914"));
        backControl.setOnAction(() -> {
            SoundService.playNav();
            onBack.run();
        });

        topBar.getChildren().add(backControl);
        root.setTop(topBar);

        HBox mainContent = new HBox(40);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setPadding(new Insets(40));

        ImageView posterView = new ImageView();
        try {
            posterView.setImage(new Image(movie.getPosterUrl(), true));
        } catch (Exception e) {
            System.err.println("Could not load poster image.");
        }
        posterView.setFitWidth(300);
        posterView.setFitHeight(450);
        posterView.setPreserveRatio(true); 
        posterView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 20, 0, 0, 10); -fx-background-color: #222;");

        VBox infoBox = new VBox(15);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        
        HBox.setHgrow(infoBox, Priority.ALWAYS);
        infoBox.setMaxWidth(Double.MAX_VALUE);

        Label movieTitle = new Label(movie.getTitle());
        movieTitle.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        movieTitle.setTextFill(Color.WHITE);
        movieTitle.setWrapText(true);

        Label meta = new Label(movie.getGenre() + "  •  " + movie.getYear());
        meta.setFont(Font.font("Arial", 18));
        meta.setTextFill(Color.GRAY);

        Label description = new Label(movie.getDescription());
        description.setFont(Font.font("Arial", 16));
        description.setTextFill(Color.LIGHTGRAY);
        description.setWrapText(true);
        description.setTextAlignment(TextAlignment.LEFT);

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));

        CustomControl watchTrailerBtn = new CustomControl("▶  WATCH TRAILER", 18, Color.WHITE, Color.BLACK);
        watchTrailerBtn.getLabel().setFont(Font.font("Arial", FontWeight.BOLD, 18));
        watchTrailerBtn.setStyle("-fx-background-color: #E50914; -fx-background-radius: 5; -fx-padding: 12 24; -fx-cursor: hand;");
        watchTrailerBtn.setOnAction(() -> openTrailerInBrowser(movie.getYoutubeVideoId()));

        CustomControl addToListBtn = new CustomControl("+  ADD TO MY LIST", 18, Color.WHITE, Color.WHITE);
        addToListBtn.getLabel().setFont(Font.font("Arial", FontWeight.BOLD, 18));
        addToListBtn.setStyle("-fx-background-color: rgba(109,109,110,0.7); -fx-background-radius: 5; -fx-padding: 12 24; -fx-cursor: hand;");
        
        if (WatchlistService.getWatchlist().stream().anyMatch(m -> m.getTitle().equals(movie.getTitle()))) {
            addToListBtn.getLabel().setText("✓  IN MY LIST");
        }

        addToListBtn.setOnAction(() -> {
            if (WatchlistService.addMovie(movie)) {
                addToListBtn.getLabel().setText("✓  ADDED TO LIST");
            } else {
                addToListBtn.getLabel().setText("✓  ALREADY IN LIST");
            }
        });

        buttonBox.getChildren().addAll(watchTrailerBtn, addToListBtn);
        infoBox.getChildren().addAll(movieTitle, meta, description, buttonBox);

        mainContent.getChildren().addAll(posterView, infoBox);
        
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: #101010; -fx-background-color: #101010;");
        
        root.setCenter(scrollPane);
    }

    private void openTrailerInBrowser(String videoId) {
        try {
            String url = "https://www.youtube.com/watch?v=" + videoId;
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (Exception ex) {
            System.err.println("Could not open browser: " + ex.getMessage());
        }
    }

    public BorderPane getRoot() { return root; }
}