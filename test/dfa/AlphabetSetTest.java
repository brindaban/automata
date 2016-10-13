package dfa;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlphabetSetTest {
    @Test
    public void should_be_truef_or_correct_alphabet() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");

        AlphabetSet alphabateSet = new AlphabetSet(alphabets);

        assertTrue(alphabateSet.isValidAlphabet("0"));
        assertTrue(alphabateSet.isValidAlphabet("1"));

        assertFalse(alphabateSet.isValidAlphabet("2"));
    }

    @Test
    public void should_be_false_for_incorrect_alphabet() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");

        AlphabetSet alphabateSet = new AlphabetSet(alphabets);
        assertFalse(alphabateSet.isValidAlphabet("2"));
    }
}