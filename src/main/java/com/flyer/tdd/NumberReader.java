package com.flyer.tdd;

import com.flyer.tdd.exceptions.InvalidInputException;
import com.flyer.tdd.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Get number input from user stdin, validate and return an array
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-04
 */

public class NumberReader {

    public final Pattern INPUT_REGEX;

    private BufferedReader br;

    public NumberReader() {
        INPUT_REGEX = Pattern.compile("^" +
                String.join("", Collections.nCopies(Constants.INPUT_SIZE - 1, "(\\s*\\d\\s+)"))
                + "(\\s*\\d\\s*)$");
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int[] readUserInput() throws IOException, InvalidInputException {
        int[] arr = new int[Constants.INPUT_SIZE];

        String input = this.br.readLine();
        if (null == input) throw new InvalidInputException();
        Matcher matcher = INPUT_REGEX.matcher(input);
        if (matcher.matches()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                arr[i - 1] = Integer.parseInt(matcher.group(i).trim());
            }
        } else throw new InvalidInputException();

        if (hasDuplicates(arr)) throw new InvalidInputException();
        return arr;
    }

    public void close() throws IOException {
        if (this.br != null) this.br.close();
    }

    private boolean hasDuplicates(int[] arr) {
        boolean[] bitmap = new boolean[10];
        for (int i : arr) {
            if (!(bitmap[i] ^= true)) return true;
        }
        return false;
    }
}
