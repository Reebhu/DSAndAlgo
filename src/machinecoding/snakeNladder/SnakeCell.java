package machinecoding.snakeNladder;

public class SnakeCell extends Cell {
	Integer headValue;
	Cell tail;

	public SnakeCell(Cell tail, Integer headValue) {
		super(headValue);
	}

	@Override
	public Cell visit(CellVisitor visitor, Player player) {
		return visitor.visitSnakeCell(this, player);
	}

	public Cell moveToTail(Player player) {
		Cell cell = player.getCurrCell();
		player.setCurrCell(tail);
		return tail;
	}

}
