package hu.szeredniklaszlo.solutions.s06;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution06Part2 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 6;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		String line = inputLines.get(0);
		Device device = new Device(line, 14);
		int solution = device.findLastCharOfFirstChunkWithMarker();

		System.out.println(solution);
	}
}
