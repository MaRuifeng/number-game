package com.flyer.tdd;

import com.flyer.tdd.entities.MatchResult;
import com.flyer.tdd.exceptions.InvalidInputException;
import com.flyer.tdd.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Game moderator that prompts user input, performs match check and renders result.
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-11
 */

public class GameModerator {
    private NumberReader reader;
    private NumberChecker checker;

    public GameModerator() {
        this.reader = new NumberReader();
        this.checker = new NumberChecker(Arrays.asList(new PositionChecker(), new OccurrenceChecker()));
    }

    public int[] generateTargetArray() {
        List<Integer> intList = new ArrayList<>();

        do {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 10);
            if (!intList.contains(randomInt)) intList.add(randomInt);
        } while (intList.size() < Constants.INPUT_SIZE);

        return intList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void play(int[] targetArray) throws IOException, InvalidInputException {
        try {
            while (!isGameEnd()) {
                int[] input = this.reader.readUserInput();
                this.checker.check(targetArray, input);
                System.out.println(this.getChecker().printResult());
            }
        } finally {
            this.reader.close();
        }
    }

    public boolean isGameEnd() {
        if (this.checker.getResultList() == null || this.checker.getResultList().isEmpty()) return false;
        for (MatchResult result : this.checker.getResultList()) {
            if (result.getCount() != Constants.INPUT_SIZE) return false;
        }
        return true;
    }

    public NumberReader getReader() {
        return reader;
    }

    public NumberChecker getChecker() {
        return checker;
    }
}
