package com.example;

import java.util.List;

import com.example.components.CustomControl;
import com.example.components.MovieCard;
import com.example.controller.HomeController;
import com.example.controller.VideoPlayerController;
import com.example.model.Movie;
import com.example.service.WatchlistService;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private Scene scene;
    private HomeController homeController;

    @Override
    public void start(Stage primaryStage) {
        // ENHANCEMENT #1: Animated Intro Screen
        StackPane splashScreen = new StackPane();
        splashScreen.setStyle("-fx-background-color: #101010;");
        
        Label splashLogo = new Label("CINEMAX");
        splashLogo.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        splashLogo.setTextFill(Color.web("#E50914"));
        
        splashScreen.getChildren().add(splashLogo);
        
        // Fade In, Pause, Fade Out
        FadeTransition fadeIn = new FadeTransition(Duration.millis(800), splashLogo);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        
        PauseTransition pause = new PauseTransition(Duration.millis(1200));
        
        FadeTransition fadeOut = new FadeTransition(Duration.millis(800), splashScreen);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        
        SequentialTransition sequence = new SequentialTransition(fadeIn, pause, fadeOut);
        sequence.setOnFinished(e -> {
            // After intro, load the main app
            homeController = new HomeController(this::showVideoPlayer, this::showWatchlist);
            scene.setRoot(homeController.getRoot());
        });
        
        // Set initial scene to the splash screen
        scene = new Scene(splashScreen, 1280, 800);
        
        if (getClass().getResource("/css/style.css") != null) {
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        }

        primaryStage.setTitle("CINEMAX");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(600);
        primaryStage.show();
        
        // Start the animation sequence
        sequence.play();
    }

    private void showVideoPlayer(Movie movie) {
        VideoPlayerController playerController = new VideoPlayerController(movie, this::showHome);
        scene.setRoot(playerController.getRoot());
    }

    private void showHome() {
        scene.setRoot(homeController.getRoot());
    }

    private void showWatchlist() {
        BorderPane watchlistRoot = new BorderPane();
        watchlistRoot.setStyle("-fx-background-color: #101010;");

        VBox topContainer = new VBox(20);
        topContainer.setStyle("-fx-padding: 20; -fx-background-color: #181818;");
        
        CustomControl backControl = new CustomControl("←  Back to Home", 16, Color.WHITE, Color.web("#E50914"));
        backControl.setOnAction(this::showHome);

        Label title = new Label("♥  My List");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        title.setTextFill(Color.WHITE);

        topContainer.getChildren().addAll(backControl, title);
        watchlistRoot.setTop(topContainer);

        FlowPane grid = new FlowPane(15, 15);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setStyle("-fx-padding: 30;");

        List<Movie> list = WatchlistService.getWatchlist();
        
        if (list.isEmpty()) {
            Label emptyLabel = new Label("You haven't added any movies or shows to your list yet.");
            emptyLabel.setFont(Font.font("Arial", 18));
            emptyLabel.setTextFill(Color.GRAY);
            VBox emptyBox = new VBox(emptyLabel);
            emptyBox.setAlignment(Pos.CENTER);
            watchlistRoot.setCenter(emptyBox);
        } else {
            for (Movie movie : list) {
                MovieCard card = new MovieCard(movie, () -> showVideoPlayer(movie));
                grid.getChildren().add(card);
            }
            
            ScrollPane scrollPane = new ScrollPane(grid);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background: #101010; -fx-background-color: #101010;");
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            
            watchlistRoot.setCenter(scrollPane);
        }

        scene.setRoot(watchlistRoot);
    }

    public static void main(String[] args) {
        launch(args);
    }
}