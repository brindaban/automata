package dfa;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class FiniteAutomataTest {
    private FiniteAutomata mechine;

    @Before
    public void setUp() throws Exception {
        State Q0 = new State("Q0");
        State Q1 = new State("Q1");
        State Q2 = new State("Q2");

        ArrayList<State> setOfStates = new ArrayList<>();
        setOfStates.addAll(asList(Q0,Q1,Q2));

        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.addAll(asList("1", "0"));


        AlphabetSet alphabetSet = new AlphabetSet(alphabets);

        HashMap<String, State> directionForQ0 = new HashMap<>();
        directionForQ0.put("0",Q0);
        directionForQ0.put("2",Q0);
        directionForQ0.put("1",Q1);

        HashMap<String, State> directionForQ1 = new HashMap<>();
        directionForQ1.put("0",Q1);
        directionForQ1.put("1",Q2);

        HashMap<String, State> directionForQ2 = new HashMap<>();
        directionForQ2.put("0",Q2);
        directionForQ2.put("1",Q2);

        HashMap<State, HashMap<String, State>> transitionTable = new HashMap<>();

        transitionTable.put(Q0,directionForQ0);
        transitionTable.put(Q1,directionForQ1);
        transitionTable.put(Q2,directionForQ2);

        TransitionFunction transitionFunction = new TransitionFunction(transitionTable);

        ArrayList<State> setOfFinalState = new ArrayList<>();
        setOfFinalState.add(Q1);

        mechine = new FiniteAutomata(setOfStates, alphabetSet, transitionFunction, Q0, setOfFinalState);

    }

    @Test
    public void should_recognize_100000_for_a_FA_of_power_of_2() throws Exception {
        assertTrue(mechine.isAccepeted("100000"));
    }

    @Test
    public void should_not_recognize_10010_for_a_FA_of_power_of_2() throws Exception {
        assertFalse(mechine.isAccepeted("10010"));
    }

    @Test
    public void should_not_recognise_if_there_is_any_wrong_alphabet() throws Exception {
        assertFalse(mechine.isAccepeted("120112"));
    }
}