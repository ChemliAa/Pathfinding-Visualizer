package PathFindingVisualizer;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class BreadthFirstSearch extends ShortestPathAlgorithm {

	@Override
	public List<Cell> shortestPath(Grid grid) {
		List<Cell> shortestPath=new ArrayList<>();
		Cell start=grid.getStart();
		Cell end=grid.getEnd();
        boolean[] visited = new boolean[grid.getWidth()*grid.getHeight()];
		Cell[] precedent=new Cell[grid.getWidth()*grid.getHeight()];
        Queue<Cell> queue=new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty())
		{
			Cell current=queue.poll();
			visited[current.getNumber()]=true;
			if (current==end)
				break;
			for(Cell neighbor:grid.getEmptyNeighbors(current.getNumber()))
			{
				if (!visited[neighbor.getNumber()])
					{queue.add(neighbor);
					precedent[neighbor.getNumber()]=current;}
			}
		}
		if (!visited[end.getNumber()])
			return null;
		Cell search=end;
		while(search!=start && search!=null)
		{
			shortestPath.add(search);	
			search=precedent[search.getNumber()];
		}
		shortestPath.add(start);	
		Collections.reverse(shortestPath);
		return shortestPath;
	}
	

	@Override
	public List<Cell> tracedPath(Grid grid) {
		List<Cell> tracedPath=new ArrayList<>();
		Cell start=grid.getStart();
		Cell end=grid.getEnd();
        boolean[] visited = new boolean[grid.getWidth()*grid.getHeight()];
		Queue<Cell> queue=new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty())
		{
			Cell current=queue.poll();
			visited[current.getNumber()]=true;
			tracedPath.add(current);
			if (current==end)
				break;
			for(Cell neighbor:grid.getEmptyNeighbors(current.getNumber()))
			{	
				if (!visited[neighbor.getNumber()])
					queue.add(neighbor);

			}
		}
		return tracedPath;
	}
	
}
