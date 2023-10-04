package PathFindingVisualizer;
import java.util.List;
import java.util.ArrayList;
public class Grid {
	private List<List<Cell>> gridShape=new ArrayList<>();
	private Integer height;
	private Integer width;
	private Integer start;
	private Integer end;
	
	public List<List<Cell>> getGridShape() {
		return gridShape;
	}

	public void setGridShape(List<List<Cell>> gridShape) {
		this.gridShape = gridShape;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	public void setObstacle(Integer cellNumber)
	{
		if(!gridShape.isEmpty())
		{	
			gridShape.get(cellNumber/width).get(cellNumber%width).setType(CellType.obstacle);
		}
	}
	public Cell getStart() {
		return gridShape.get(this.start/width).get(this.start%width);
	}

	public void setStart(Integer start) {
		if(!gridShape.isEmpty())
		{	
			gridShape.get(this.start/width).get(this.start%width).setType(CellType.blank);
			gridShape.get(start/width).get(start%width).setType(CellType.start);
		}
		this.start = start;
	}

	public Cell getEnd() {
		return gridShape.get(this.end/width).get(this.end%width);
	}

	public void setEnd(Integer end) {
		if(!gridShape.isEmpty())
		{	
			gridShape.get(this.end/width).get(this.end%width).setType(CellType.blank);
			gridShape.get(end/width).get(end%width).setType(CellType.end);
		}
		this.end = end;
	}
	public List<Cell> getEmptyNeighbors(int cellNumber)
	{
		List<Cell> emptyNeighbors=new ArrayList<>();
		int row=(cellNumber)/width;
		int col=(cellNumber)%width;
		if((col<this.getWidth()-1) && ((gridShape.get(row).get(col+1).getType()==CellType.blank)||(gridShape.get(row).get(col+1).getType()==CellType.end)))
		{
			emptyNeighbors.add(gridShape.get(row).get(col+1));
		}
		if((row<this.getHeight()-1) && ((gridShape.get(row+1).get(col).getType()==CellType.blank)||(gridShape.get(row+1).get(col).getType()==CellType.end)))
		{
			emptyNeighbors.add(gridShape.get(row+1).get(col));
		}
		if((col>0) && ((gridShape.get(row).get(col-1).getType()==CellType.blank)||(gridShape.get(row).get(col-1).getType()==CellType.end)))
		{
			emptyNeighbors.add(gridShape.get(row).get(col-1));
		}
		if((row>0) && ((gridShape.get(row-1).get(col).getType()==CellType.blank)||(gridShape.get(row-1).get(col).getType()==CellType.end)))
		{
			emptyNeighbors.add(gridShape.get(row-1).get(col));
		}
		
		
		
		
		return emptyNeighbors;
	}
	public Grid(int width,int height,int start,int end)
	{
		this.start=start;
		this.end=end;
		this.width=width;
		this.height=height;
		for(int i=0;i<height;i++)
		{
			List<Cell> row = new ArrayList<>();
			for(int j=0;j<width;j++)
			{	
				if(i*width+j==start)
				{
					Cell cell=new Cell(CellType.start,i*width+j);
					row.add(cell);
				}
				else if(i*width+j==end)
				{
					Cell cell=new Cell(CellType.end,i*width+j);
					row.add(cell);
				}
				else 
				{
					Cell cell=new Cell(CellType.blank,i*width+j);
					row.add(cell);
				}
				
			}
			gridShape.add(row);
			
		}
	}

}
