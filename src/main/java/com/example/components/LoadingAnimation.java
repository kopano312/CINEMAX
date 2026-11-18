package com.example.components;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class LoadingAnimation extends StackPane {
    private final Timeline timeline;

    public LoadingAnimation() {
        setStyle("-fx-background-color: #101010;");
        Circle outerRing = new Circle(40);
        outerRing.setFill(Color.TRANSPARENT);
        outerRing.setStroke(Color.web("#E50914"));
        outerRing.setStrokeWidth(4);

        Circle innerDot = new Circle(10);
        innerDot.setFill(Color.web("#E50914"));

        Label loadingText = new Label("CINEMAX");
        loadingText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        loadingText.setTextFill(Color.WHITE);

        Label subText = new Label("Loading trailer...");
        subText.setFont(Font.font("Arial", 14));
        subText.setTextFill(Color.GRAY);

        VBox textBox = new VBox(5, loadingText, subText);
        textBox.setAlignment(javafx.geometry.Pos.CENTER);

        getChildren().addAll(outerRing, innerDot, textBox);
        setAlignment(javafx.geometry.Pos.CENTER);

        RotateTransition rotate = new RotateTransition(Duration.seconds(1.2), innerDot);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);

        ScaleTransition pulse = new ScaleTransition(Duration.seconds(0.8), loadingText);
        pulse.setFromX(1.0); pulse.setFromY(1.0); pulse.setToX(1.15); pulse.setToY(1.15);
        pulse.setAutoReverse(true); pulse.setCycleCount(Animation.INDEFINITE);

        FadeTransition fade = new FadeTransition(Duration.seconds(1.5), subText);
        fade.setFromValue(1.0); fade.setToValue(0.3);
        fade.setAutoReverse(true); fade.setCycleCount(Animation.INDEFINITE);

        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(outerRing.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(outerRing.rotateProperty(), 360))
        );
        timeline.setCycleCount(Animation.INDEFINITE);

        rotate.play(); pulse.play(); fade.play(); timeline.play();
    }
    public void stop() { timeline.stop(); }
}