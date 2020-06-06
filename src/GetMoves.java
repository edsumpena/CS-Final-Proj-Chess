import java.util.ArrayList;
import java.util.Arrays;

public class GetMoves {
	public static ArrayList<Integer> calculate(Piece[][] board, int[] selected) {
		Piece p = board[selected[0]][selected[1]];

		ArrayList<Integer> moves = new ArrayList<>();

		if (p == Piece.WHITE_PAWN) {
			// System.out.println("Selected: " + Arrays.toString(new int[] {selected[0],
			// selected[1]}) + " " + Arrays.toString(new int[] {selected[0] - 2,
			// selected[1]}) + " " +
			// board[selected[0] - 2][selected[1]] + " " + board[selected[0] -
			// 1][selected[1]]);

			if (selected[0] == 6 && validMove(board, p, selected, new int[] { selected[0] - 2, selected[1] }, false)) {
				moves.add(selected[0] - 2);
				moves.add(selected[1]);
			}
			if (validMove(board, p, selected, new int[] { selected[0] - 1, selected[1] }, false)) {
				moves.add(selected[0] - 1);
				moves.add(selected[1]);
			}
			if (selected[1] - 1 >= 0
					&& validMove(board, p, selected, new int[] { selected[0] - 1, selected[1] - 1 }, false)) {
				moves.add(selected[0] - 1);
				moves.add(selected[1] - 1);
			}
			if (selected[1] + 1 <= 7
					&& validMove(board, p, selected, new int[] { selected[0] - 1, selected[1] + 1 }, false)) {
				moves.add(selected[0] - 1);
				moves.add(selected[1] + 1);
			}
		} else if (p == Piece.BLACK_PAWN) {
			if (selected[0] == 1 && validMove(board, p, selected, new int[] { selected[0] + 2, selected[1] }, false)) {
				moves.add(selected[0] + 2);
				moves.add(selected[1]);
			}
			if (validMove(board, p, selected, new int[] { selected[0] + 1, selected[1] }, false)) {
				moves.add(selected[0] + 1);
				moves.add(selected[1]);
			}
			if (selected[1] - 1 >= 0
					&& validMove(board, p, selected, new int[] { selected[0] + 1, selected[1] - 1 }, false)) {
				moves.add(selected[0] + 1);
				moves.add(selected[1] - 1);
			}
			if (selected[1] + 1 <= 7
					&& validMove(board, p, selected, new int[] { selected[0] + 1, selected[1] + 1 }, false)) {
				moves.add(selected[0] + 1);
				moves.add(selected[1] + 1);
			}
		} else if (p == Piece.WHITE_ROOK || p == Piece.BLACK_ROOK) {
			for (int i = selected[0] - 1; i >= 0; i--) {
				if (board[i][selected[1]] == null || !sameColor(board[i][selected[1]], p)) {
					moves.add(i);
					moves.add(selected[1]);
				}

				if (board[i][selected[1]] != null)
					break;
			}

			for (int i = selected[0] + 1; i < board.length; i++) {
				if (board[i][selected[1]] == null || !sameColor(board[i][selected[1]], p)) {
					moves.add(i);
					moves.add(selected[1]);
				}

				if (board[i][selected[1]] != null)
					break;
			}

			for (int i = selected[1] - 1; i >= 0; i--) {
				if (board[i][selected[1]] == null || !sameColor(board[selected[0]][i], p)) {
					moves.add(selected[0]);
					moves.add(i);
				}

				if (board[selected[0]][i] != null)
					break;
			}

			for (int i = selected[1] + 1; i < board[0].length; i++) {
				if (board[i][selected[1]] == null || !sameColor(board[selected[0]][i], p)) {
					moves.add(selected[0]);
					moves.add(i);
				}

				if (board[selected[0]][i] != null)
					break;
			}
		}

		return moves;

	}

	private static boolean sameColor(Piece one, Piece two) {
		return isWhite(one) == isWhite(two);
	}

	private static boolean isWhite(Piece p) {
		return (p == Piece.WHITE_BISHOP || p == Piece.WHITE_KING || p == Piece.WHITE_KNIGHT || p == Piece.WHITE_PAWN
				|| p == Piece.WHITE_QUEEN || p == Piece.WHITE_ROOK);
	}

	private static boolean validMove(Piece[][] board, Piece p, int[] selected, int[] target, boolean canJump) {
		if (p == Piece.WHITE_PAWN) {
			if (board[target[0]][target[1]] == null && selected[0] == target[0] + 2 && selected[1] == target[1]
					&& board[target[0] + 1][target[1]] == null) {
				return true;
			} else if (board[target[0]][target[1]] == null && selected[0] == target[0] + 1
					&& selected[1] == target[1]) {
				return true;
			} else if (board[target[0]][target[1]] != null && !sameColor(board[target[0]][target[1]], p)
					&& Math.abs(selected[1] - target[1]) == 1 && selected[0] == target[0] + 1) {
				return true;
			} else {
				return false;
			}
		} else if (p == Piece.BLACK_PAWN) {
			if (board[target[0]][target[1]] == null && selected[0] == target[0] - 2 && selected[1] == target[1]
					&& board[target[0] - 1][target[1]] == null) {
				return true;
			} else if (board[target[0]][target[1]] == null && selected[0] == target[0] - 1
					&& selected[1] == target[1]) {
				return true;
			} else if (board[target[0]][target[1]] != null && !sameColor(board[target[0]][target[1]], p)
					&& Math.abs(selected[1] - target[1]) == 1 && selected[0] == target[0] - 1) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
