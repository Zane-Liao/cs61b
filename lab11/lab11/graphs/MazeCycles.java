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

    private Maze maze;
    private int[] nodeTo;
    private boolean isFound = false;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        nodeTo = new int[maze.N() * maze.N()];
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfs(0, 1);

    }
    // Other people's solutions
    private void dfs(int u, int v) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                nodeTo[w] = v;
                dfs(v, w);
            } else if (w != u) {
                edgeTo[w] = v;
                announce();
                for (int x = v; x != w; x = nodeTo[x]) {
                    edgeTo[x] = nodeTo[x];
                    announce();
                }
                isFound = true;
            }
            if (isFound) return;
        }
    }
}

