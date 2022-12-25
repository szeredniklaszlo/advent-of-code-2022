package hu.szeredniklaszlo.solutions.s08;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution08Part2 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 8;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		Forest forest = new Forest(inputLines);
		long maxScenicScore = forest.calcMaxScenicScore();

		System.out.println(maxScenicScore);
	}
}
