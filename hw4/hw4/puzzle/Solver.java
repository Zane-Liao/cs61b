package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;

public class Solver implements WorldState {

    /**
     * */
    public Solver(WorldState initial) {
        MinPQ state_steps = new MinPQ();
        state_steps.insert(0);
        isGoal();
    }

    private class SearchNode {
        
    }

    /**
     * */
    public int moves() {
        return 0;
    }

    /**
     * */
    public Iterable<WorldState> solution() {
        return null;
    }

    @Override
    public int estimatedDistanceToGoal() {
        return 0;
    }

    @Override
    public Iterable<WorldState> neighbors() {
        return null;
    }

    @Override
    public boolean isGoal() {
        return WorldState.super.isGoal();
    }
}