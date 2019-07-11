package com.flyer.tdd;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameModeratorTest {

    private GameModerator moderator = new GameModerator();

    @Test
    public final void shouldInitializeWithNumberReaderAndNumberChecker() {
        assertNotNull(moderator.getReader());
        assertNotNull(moderator.getChecker());

        List<String> subCheckerList = Arrays.asList(PositionChecker.class.getCanonicalName(),
                OccurrenceChecker.class.getCanonicalName());

        moderator.getChecker().getCheckerList().stream().forEach(checker ->
                assertTrue(subCheckerList.contains(checker.getClass().getCanonicalName())));
    }

    @Test
    public final void shouldGenerateATargetArrayWithRandomUniqueIntegers() {
        assertEquals(4, Arrays.stream(moderator.generateTargetArray()).distinct().count());
    }

    @Test
    public final void shouldIndicateGameEndWhenAllNumbersMatch() {
        moderator.getChecker().check(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        assertTrue(moderator.isGameEnd());
    }

    @Test
    public final void shouldIndicateGameInProgressWhenNotAllNumbersMatch() {
        moderator.getChecker().check(new int[]{1, 2, 3, 4}, new int[]{5, 2, 3, 4});
        assertFalse(moderator.isGameEnd());
    }

    @Test
    public final void shouldPlayTheGameUntilAllNumbersMatch() throws Exception {
        int[] target = {1, 3, 5, 6};
        String[] sources = {"1 3 2 4", "2 3 4 1", "4 5 2 1", "1 5 3 6", "1 3 5 6"};

        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(String.join("\r", sources).getBytes()));
            System.setOut(new PrintStream(outContent));
            moderator = new GameModerator();
            moderator.play(target);
        } catch (Exception e) {
            throw e;
        } finally {
            System.setIn(stdin);
            System.setOut(stdout);
        }

        assertTrue(moderator.isGameEnd());
        assertEquals("2 A 2 B\n" +
                "1 A 2 B\n" +
                "0 A 2 B\n" +
                "2 A 4 B\n" +
                "4 A 4 B\n", outContent.toString());

        // consider mockito to test BufferedReader closure call
    }

}