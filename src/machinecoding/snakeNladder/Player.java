package machinecoding.snakeNladder;

import java.util.Random;

public class Player {
	Cell currCell;
	CellVisitor visitor;

	public Player(Grid grid) {
		visitor = new CellVisitor();
		currCell = grid.getGrid()[0];
	}

	public Cell getCurrCell() {
		return currCell;
	}

	public void setCurrCell(Cell currCell) {
		this.currCell = currCell;
	}

	public Cell rollDie(Grid grid) {
		Random random = new Random();
		Integer dieFace = random.nextInt(1, 7);
		if (dieFace + currCell.getNumber() <= 100) {
			Cell[] cellArr = grid.getGrid();
			return cellArr[currCell.getNumber() + dieFace].visit(visitor, this);
		}
		return currCell;
	}
}
