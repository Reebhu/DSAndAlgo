package machinecoding.snakeNladder;

public class LadderCell extends Cell {
	Integer number;
	Cell targetCell;

	protected LadderCell(Integer number) {
		super(number);
		this.number = number;
	}

	void setTargetCell(Cell target) {
		this.targetCell = target;
	}

	@Override
	public Cell visit(CellVisitor visitor, Player player) {
		return visitor.visitLadderCell(this, player);
	}

	public Cell moveToTop(Player player) {
		player.setCurrCell(targetCell);
		return targetCell;
	}
}
