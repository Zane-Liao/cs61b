package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
//  Inherits public fields:
//    public int[] distTo;
//    public int[] edgeTo;
//    public boolean[] marked;


    private boolean targetFound;

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfsCycle(0, 1);
    }
    // Helper methods go here
    // Unfinished
    public void dfsCycle(int parentNode, int v) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                announce();
                dfsCycle(v, w);
            } else if (w != parentNode) {
                edgeTo[w] = v;
                announce();
//                if (marked[w] && edgeTo[w] != v) {
//                    edgeTo[w] = v;
//                    announce();
//                }
                return;
            }
        }
    }
}

