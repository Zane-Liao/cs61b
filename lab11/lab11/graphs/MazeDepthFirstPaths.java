package lab11.graphs;
import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeDepthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeDepthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    private void dfs(int v) {
        Stack<Integer> remarked = new Stack<>();
        remarked.push(v);
        marked[v] = true;
        announce();

        while (!remarked.isEmpty()) {
            int current = remarked.pop();

            if (current == t) {
                targetFound = true;
            }

            for (int w : maze.adj(current)) {
                if (!marked[w]) {
                    remarked.push(w);
                    announce();
                    distTo[w] = distTo[current] + 1;
                    edgeTo[w] = v;
                    dfs(w);
                }
            }
        }
    }

    @Override
    public void solve() {
        dfs(s);
    }
}

