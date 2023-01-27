package hu.szeredniklaszlo.solutions.s09;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;
import hu.szeredniklaszlo.solutions.s09.command.Command;
import hu.szeredniklaszlo.solutions.s09.command.CommandFactory;

public class Solution09Part1 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 9;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		final int FIRST_CHECKED_CYCLE = 20;
		final int CYCLE_CHECK_STEP_SIZE = 40;

		int totalCycleSignalStrength = 0;

		int currCycle = 0;
		int registerXVal = 1;

		for (String line : inputLines) {
			Command command = CommandFactory.createCommand(line);

			currCycle += command.getCost();
			if (currCycle % 40 == 20 ||
				(currCycle % 40 == 21 && command.getCost() == 2)) {
				totalCycleSignalStrength += calcCurrCycleSignalStrength(currCycle - ((currCycle % CYCLE_CHECK_STEP_SIZE) % FIRST_CHECKED_CYCLE), registerXVal);
			}

			registerXVal += command.getValue();
		}

		System.out.println(totalCycleSignalStrength);
	}

	private int calcCurrCycleSignalStrength(int cycleNum, int registerXVal) {
		int result = cycleNum * registerXVal;
		System.out.printf("%d.\tX: %d\tCV: %d%n", cycleNum, registerXVal, result);
		return result;
	}
}
