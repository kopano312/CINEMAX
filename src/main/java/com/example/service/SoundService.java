package com.example.service;

import java.net.URL;

import javafx.scene.media.AudioClip;

public class SoundService {
    private static AudioClip hoverSound;
    private static AudioClip clickSound;
    private static AudioClip navSound;

    static {
        try {
            // Changed extensions from .wav to .mp3
            URL hoverUrl = SoundService.class.getResource("/sounds/hover.mp3");
            URL clickUrl = SoundService.class.getResource("/sounds/click.mp3");
            URL navUrl = SoundService.class.getResource("/sounds/nav.mp3");
            
            if (hoverUrl != null) hoverSound = new AudioClip(hoverUrl.toString());
            if (clickUrl != null) clickSound = new AudioClip(clickUrl.toString());
            if (navUrl != null) navSound = new AudioClip(navUrl.toString());
            
            System.out.println("Sound Service Initialized.");
        } catch (Exception e) {
            System.err.println("Sound files not found or could not be loaded. Sound effects disabled.");
        }
    }

    public static void playHover() { 
        if (hoverSound != null) hoverSound.play(0.2); // 0.2 volume for subtlety
    }
    
    public static void playClick() { 
        if (clickSound != null) clickSound.play(0.5); 
    }
    
    public static void playNav() { 
        if (navSound != null) navSound.play(0.4); 
    }
}