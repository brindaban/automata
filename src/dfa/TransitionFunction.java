package dfa;

import java.util.HashMap;

public class TransitionFunction {
    private HashMap<State, HashMap<String, State>> transitionTable;

    public TransitionFunction(HashMap<State, HashMap<String, State>> transitionTable) {
        this.transitionTable = transitionTable;
    }

    public State execute(State presentState, String currentAlphabet) {
        return transitionTable.get(presentState).get(currentAlphabet);
    }
}
