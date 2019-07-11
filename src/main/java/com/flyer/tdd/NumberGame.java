package com.flyer.tdd;

import com.flyer.tdd.exceptions.InvalidInputException;

import java.io.IOException;

/**
 * Game entry-point
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-11
 */
public class NumberGame {

    public static void main(String[] args) {
        GameModerator moderator = new GameModerator();

        System.out.println("Welcome to the number game! Enter 4 unique single digit number separated by space:");

        try {
            moderator.play(moderator.generateTargetArray());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

        System.out.println("Bravo! You got the numbers!");
    }
}
