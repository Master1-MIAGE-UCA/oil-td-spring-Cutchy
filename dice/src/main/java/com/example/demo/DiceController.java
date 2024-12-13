package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dice")
public class DiceController {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceController(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    @GetMapping("/rollDice")
    public int rollSingleDice() {
        int result = dice.roll();

        DiceRollLog log = new DiceRollLog(1, List.of(result), LocalDateTime.now());
        diceRollLogRepository.save(log);

        return result;
    }

    @GetMapping("/rollDices/{x}")
    public List<Integer> rollMultipleDices(@PathVariable("x") int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Le nombre de dés doit être supérieur ou égal à 1.");
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            results.add(dice.roll());
        }

        DiceRollLog log = new DiceRollLog(x, results, LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }
}
