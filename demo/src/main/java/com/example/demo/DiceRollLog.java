package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entité représentant un log de lancé de dés.
 */
@Entity
public class DiceRollLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int diceCount;

    @ElementCollection
    @CollectionTable(name = "dice_results", joinColumns = @JoinColumn(name = "log_id"))
    @Column(name = "result")
    private List<Integer> results;

    private LocalDateTime timestamp;

    // Constructeurs
    public DiceRollLog() {
    }

    public DiceRollLog(int diceCount, List<Integer> results, LocalDateTime timestamp) {
        this.diceCount = diceCount;
        this.results = results;
        this.timestamp = timestamp;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
