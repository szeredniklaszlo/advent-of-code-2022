package hu.szeredniklaszlo.solutions.s01;

import static hu.szeredniklaszlo.solutions.s01.AbstractSolution01.calcCaloriesCarriedByElvesDesc;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution01Part2 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 1;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		List<Integer> caloriesCarriedByElves = calcCaloriesCarriedByElvesDesc(inputLines);

		int sumOfTop3 = calcSumOfTop3(caloriesCarriedByElves);
		System.out.println(sumOfTop3);
	}

	private static int calcSumOfTop3(List<Integer> caloriesCarriedByElves) {
		int sumOfTop3 = 0;
		for (int i = 0; i < 3; i++) {
			sumOfTop3 += caloriesCarriedByElves.get(i);
		}
		return sumOfTop3;
	}


}
