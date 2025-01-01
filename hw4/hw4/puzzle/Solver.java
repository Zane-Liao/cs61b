package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;

public class Solver implements WorldState {

    private class SearchNode {
        private SearchNode point;
        private WorldState state;
        private int move;

        private SearchNode(SearchNode p, int m, WorldState s) {
            point = p;
            move = m;
            state = s;
        }
    }

    /**
     * */
    public Solver(WorldState initial) {
        MinPQ state_steps = new MinPQ();
        state_steps.insert(0);
        isGoal();
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