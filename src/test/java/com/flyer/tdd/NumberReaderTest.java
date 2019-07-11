package com.flyer.tdd;

import com.flyer.tdd.exceptions.InvalidInputException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NumberReaderTest {
    private NumberReader reader;

    private int[] executeReader(String data) throws Exception {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            reader = new NumberReader();
            return reader.readUserInput();
        } finally {
            System.setIn(stdin);
        }
    }

    @After
    public final void tearDown() throws IOException {
        this.reader.close();
    }

    @Test
    public final void shouldObtainProperUserInputIntoAnArray() throws Exception {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, executeReader("1 2  3    4"));
        Assert.assertArrayEquals(new int[]{3, 5, 6, 9}, executeReader("3 5 6 9 "));
        Assert.assertArrayEquals(new int[]{0, 7, 2, 3}, executeReader("0 7 2 3"));
        Assert.assertArrayEquals(new int[]{0, 7, 2, 3}, executeReader("  0 7 2 3  "));
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnInputWithDuplicates() throws Exception {
        executeReader("2 3 3 4");
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnEmptyInput() throws Exception {
        executeReader("");
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnIncompleteInput() throws Exception {
        executeReader("1 2 3");
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnExcessiveInput() throws Exception {
        executeReader("1 2 3 4 5");
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnWronglyFormattedInput() throws Exception {
        executeReader("1,2,3,4");
    }

    @Test(expected = InvalidInputException.class)
    public final void shouldThrowExceptionOnGibberishInput() throws Exception {
        executeReader("&^*)dd987 d9fd97 d 0");
    }
}