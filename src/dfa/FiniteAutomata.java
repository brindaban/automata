package dfa;

import java.util.ArrayList;

public class FiniteAutomata {
    private ArrayList<State> states;
    private AlphabetSet alphabetSet;
    private TransitionFunction transitionFunction;
    private State initialState;
    private ArrayList<State> finalStates;

    public FiniteAutomata(ArrayList<State> states, AlphabetSet alphabetSet, TransitionFunction transitionFunction, State initialState, ArrayList<State> finalStates) {
        this.states = states;
        this.alphabetSet = alphabetSet;
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }


    private boolean isFinalState(State givenState) {
        return finalStates.contains(givenState);
    }

    public boolean isAccepeted(String givenString) {
        State presentState = initialState;
        for(int index = 0; index < givenString.length(); index++){
            String currentAlphabet = givenString.substring(index,index+1);
            if (!alphabetSet.isValidAlphabet(currentAlphabet))
                return false;
            presentState = transitionFunction.execute(presentState, currentAlphabet);
            if (!states.contains(presentState))
                return false;
        }
        return isFinalState(presentState);
    }
}
