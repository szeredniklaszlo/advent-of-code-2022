package hu.szeredniklaszlo.solutions.s01;

import static hu.szeredniklaszlo.solutions.s01.AbstractSolution01.calcCaloriesCarriedByElvesDesc;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution01Part1 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 1;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		List<Integer> caloriesCarriedByElvesDesc = calcCaloriesCarriedByElvesDesc(inputLines);

		Integer top1 = caloriesCarriedByElvesDesc.get(0);
		System.out.println(top1);
	}
}
