package com.example.components;

import com.example.service.SoundService;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomControl extends StackPane {
    private final Label label;

    public CustomControl(String text, double fontSize, Color textColor, Color hoverColor) {
        label = new Label(text);
        // Using "Segoe UI Symbol" (Windows) or standard system font which has good icon support
        label.setFont(Font.font("Segoe UI Symbol", FontWeight.BOLD, fontSize));
        label.setTextFill(textColor);
        setAlignment(Pos.CENTER); 
        getChildren().add(label);
        setStyle("-fx-cursor: hand; -fx-padding: 6 12 6 12;");

        setOnMouseEntered(e -> {
            label.setTextFill(hoverColor);
            SoundService.playHover();
        });
        setOnMouseExited(e -> label.setTextFill(textColor));
    }

    public void setOnAction(Runnable action) {
        setOnMouseClicked(e -> {
            SoundService.playClick();
            action.run();
        });
    }

    public Label getLabel() {
        return label;
    }
}