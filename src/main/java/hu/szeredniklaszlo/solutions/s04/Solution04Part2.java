package hu.szeredniklaszlo.solutions.s04;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution04Part2 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 4;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		long result = inputLines.stream()
			.map(PairOfIntervals::new)
			.map(PairOfIntervals::doesIntervalsOverlap)
			.filter(overlaps -> overlaps)
			.count();

		System.out.println(result);
	}
}
