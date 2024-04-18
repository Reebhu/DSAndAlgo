package machinecoding.snakeNladder;

public abstract class Cell {

	private final Integer number;

	abstract Cell visit(CellVisitor visitor, Player player);

	public Integer getNumber() {
		return number;
	}

	protected Cell(Integer number) {
		this.number = number;
	}
}
