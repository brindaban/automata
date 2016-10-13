package dfa;

import java.util.ArrayList;

public class AlphabetSet {
    private ArrayList<String> alphabets;

    public AlphabetSet(ArrayList<String> alphabets) {
        this.alphabets = alphabets;
    }


    public boolean isValidAlphabet(String givenAlphabet) {
        return alphabets.contains(givenAlphabet);
    }
}
