package lab11.graphs;
import java.util.ArrayDeque;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private int t;
    private boolean targetFound = false;

    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        ArrayDeque<Integer> demarked = new ArrayDeque<>();
        demarked.add(v);
        marked[v] = true;
        announce();

        while (!demarked.isEmpty()) {
            int current = demarked.remove();

            if (current == t) {
                targetFound = true;
            }

            for (int w : maze.adj(current)) {
                if (!marked[w]) {
                    demarked.add(w);
                    marked[w] = true;
                    announce();
                    edgeTo[w] = current;
                    distTo[w] = distTo[current] + 1;
                }
            }
        }
    }


    @Override
    public void solve() {
         bfs(s);
    }
}

