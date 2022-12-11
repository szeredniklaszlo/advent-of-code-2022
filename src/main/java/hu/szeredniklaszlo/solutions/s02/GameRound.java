package hu.szeredniklaszlo.solutions.s02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class GameRound {
	private final OpponentSelection opponentSelection;
	private MySelection mySelection;
	private Winner winner;

	public GameRound(OpponentSelection opponentSelection, MySelection mySelection) {
		this.opponentSelection = opponentSelection;
		this.mySelection = mySelection;

		winner = calcWinner();
	}

	public GameRound(OpponentSelection opponentSelection, Winner winner) {
		this.opponentSelection = opponentSelection;
		this.winner = winner;

		mySelection = calcMySelection();
	}

	private MySelection calcMySelection() {
		switch (winner) {
			case X -> {
				mySelection = MySelection.valueOf(opponentSelection.getWeaker().getValue());
			}
			case Z -> {
				mySelection = MySelection.valueOf(opponentSelection.getStronger().getValue());
			}
			case Y -> {
				mySelection = MySelection.valueOf(opponentSelection.getValue());
			}
		}

		return mySelection;
	}

	public int calcMyScore() {
		return mySelection.getValue() + winner.getValue();
	}

	private Winner calcWinner() {
		if (mySelection.getValue() == opponentSelection.getWeaker().getValue()) {
			winner = Winner.X;
		} else if (mySelection.getValue() == opponentSelection.getStronger().getValue()) {
			winner = Winner.Z;
		} else {
			winner = Winner.Y;
		}

		return winner;
	}

	@RequiredArgsConstructor
	@Getter
	public enum Winner {
		X(0), Y(3), Z(6);

		private final int value;
	}
}
