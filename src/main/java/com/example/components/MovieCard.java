package com.example.components;

import com.example.model.Movie;
import com.example.service.SoundService;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class MovieCard extends VBox {
    private final Movie movie;

    public MovieCard(Movie movie, Runnable onSelect) {
        this.movie = movie;
        setSpacing(5);
        setAlignment(Pos.CENTER_LEFT);
        setPrefWidth(160);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(220);
        imageView.setPreserveRatio(false);
        imageView.setStyle("-fx-background-color: #222; -fx-background-radius: 8;");

        try {
            Image img = new Image(movie.getPosterUrl(), true);
            imageView.setImage(img);
        } catch (Exception e) {}

        // ENHANCEMENT #2: Age Rating Badge
        Label ageBadge = new Label(movie.getYear() > 2010 ? "16+" : "13+");
        ageBadge.setStyle("-fx-background-color: #E50914; -fx-text-fill: white; -fx-font-size: 10px; -fx-padding: 2 4; -fx-background-radius: 3;");
        StackPane.setAlignment(ageBadge, Pos.TOP_RIGHT);
        StackPane.setMargin(ageBadge, new Insets(5, 5, 0, 0));

        StackPane posterPane = new StackPane(imageView, ageBadge);
        posterPane.setStyle("-fx-border-color: transparent; -fx-border-width: 2; -fx-border-radius: 8;");

        Label playOverlay = new Label("▶  PLAY TRAILER");
        playOverlay.setFont(Font.font("Segoe UI Symbol", FontWeight.BOLD, 12));
        playOverlay.setTextFill(Color.WHITE);
        playOverlay.setStyle("-fx-background-color: rgba(229,9,20,0.85); -fx-padding: 6 10; -fx-background-radius: 4;");
        playOverlay.setVisible(false);
        posterPane.getChildren().add(playOverlay);

        Label titleLabel = new Label(movie.getTitle());
        titleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(150);

        // ENHANCEMENT #2: Match Percentage & Year
        HBox metaBox = new HBox(5);
        Label matchLabel = new Label("98% Match");
        matchLabel.setTextFill(Color.web("#46d369")); // Netflix Green
        matchLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        Label yearLabel = new Label(String.valueOf(movie.getYear()));
        yearLabel.setTextFill(Color.GRAY);
        yearLabel.setFont(Font.font("Arial", 11));
        metaBox.getChildren().addAll(matchLabel, yearLabel);

        getChildren().addAll(posterPane, titleLabel, metaBox);

        ScaleTransition scaleUp = new ScaleTransition(Duration.millis(200), this);
        scaleUp.setToX(1.08);
        scaleUp.setToY(1.08);

        ScaleTransition scaleDown = new ScaleTransition(Duration.millis(200), this);
        scaleDown.setToX(1.0);
        scaleDown.setToY(1.0);

        setOnMouseEntered(e -> {
            scaleUp.playFromStart();
            posterPane.setStyle("-fx-border-color: #E50914; -fx-border-width: 2; -fx-border-radius: 8; -fx-effect: dropshadow(gaussian, rgba(229,9,20,0.7), 15, 0, 0, 0);");
            playOverlay.setVisible(true);
            SoundService.playHover();
        });

        setOnMouseExited(e -> {
            scaleDown.playFromStart();
            posterPane.setStyle("-fx-border-color: transparent; -fx-border-width: 2; -fx-border-radius: 8;");
            playOverlay.setVisible(false);
        });

        setOnMouseClicked(e -> {
            SoundService.playClick();
            onSelect.run();
        });
    }

    public Movie getMovie() { return movie; }
}