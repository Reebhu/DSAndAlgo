package machinecoding.snakeNladder;

public class NumberCell extends Cell {

	protected NumberCell(Integer number) {
		super(number);
	}

	@Override
	Cell visit(CellVisitor visitor, Player player) {
		return visitor.visitNumberCell(this, player);
	}

	Cell moveToCell(Player player) {
		player.setCurrCell(this);
		return this;
	}
}
