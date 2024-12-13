package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public List<Integer> rollDices(int diceCount) {
        if (diceCount < 1) {
            throw new IllegalArgumentException("Le nombre de dés doit être supérieur ou égal à 1.");
        }

        // lance les dés
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll());
        }

        // save dans l'historique
        DiceRollLog log = new DiceRollLog(diceCount, results, LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }
}
