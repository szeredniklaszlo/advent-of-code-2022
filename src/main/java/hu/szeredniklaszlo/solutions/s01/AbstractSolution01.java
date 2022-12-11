package hu.szeredniklaszlo.solutions.s01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public abstract class AbstractSolution01 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 0;
	}

	@Override
	protected abstract void processInput(List<String> inputLines);

	protected static List<Integer> calcCaloriesCarriedByElvesDesc(List<String> inputLines) {
		List<Integer> caloriesCarriedByElves = new ArrayList<>();

		int sumForCurrentElf = 0;
		for (String line : inputLines) {
			if (line.isBlank()) {
				caloriesCarriedByElves.add(sumForCurrentElf);
				sumForCurrentElf = 0;

				continue;
			}

			sumForCurrentElf += Integer.parseInt(line);
		}

		caloriesCarriedByElves.sort(Comparator.comparingInt(item -> (Integer)item).reversed());
		return caloriesCarriedByElves;
	}
}
