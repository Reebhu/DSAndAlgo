package machinecoding.snakeNladder;

public class CellVisitor {

	Cell visitSnakeCell(SnakeCell snakeCell, Player player) {
		return snakeCell.moveToTail(player);
	}

	Cell visitLadderCell(LadderCell ladderCell, Player player) {
		return ladderCell.moveToTop(player);
	}

	Cell visitNumberCell(NumberCell numberCell, Player player) {
		return numberCell.moveToCell(player);
	}
}
