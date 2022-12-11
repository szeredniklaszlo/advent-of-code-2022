package hu.szeredniklaszlo.solutions.s02;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;
import hu.szeredniklaszlo.solutions.s02.GameRound.Winner;

public class Solution02Part2 extends AbstractSolution {
	@Override
	protected int getTaskNumber() {
		return 2;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		int sum = 0;

		for (String line : inputLines) {
			String[] choices = line.split(" ");

			GameRound gameRound = new GameRound(
				OpponentSelection.valueOf(choices[0]),
				Winner.valueOf(choices[1])
			);

			sum += gameRound.calcMyScore();
		}

		System.out.println(sum);
	}
}
