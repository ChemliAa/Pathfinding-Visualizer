package PathFindingVisualizer;

public class Cell {
	private CellType type;
	
	private Integer number;
	
	public CellType getType() {
		return type;
	}

	public void setType(CellType type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public Cell(CellType type,int number)
	{
		this.type=type;
		this.number=number;
	}
	@Override
	public String toString() {
       return String.valueOf(this.getNumber());
    }

}
