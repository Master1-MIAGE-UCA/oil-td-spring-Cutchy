package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {

    private final Random random;
    private final int sides;

    public Dice() {
        this(6); // Dé par défaut avec 6 faces
    }

    public Dice(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("Un dé doit avoir au moins une face.");
        }
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }
}
