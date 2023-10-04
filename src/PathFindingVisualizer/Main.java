package PathFindingVisualizer;

public class Main {
    public static void main(String[] args) {
    	Grid grid=new Grid(10,7, 0, 69);
    	
    	BreadthFirstSearch bfs=new BreadthFirstSearch();
    	System.out.println(grid.getGridShape());
    	System.out.println(bfs.tracedPath(grid));
    	System.out.println(bfs.shortestPath(grid));
    }
}
