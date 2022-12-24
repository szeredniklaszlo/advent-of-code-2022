package hu.szeredniklaszlo.solutions.s03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution03Part2 extends AbstractSolution {

	private static final int NUM_OF_RUCKSACKS = 3;

	@Override
	protected int getTaskNumber() {
		return 3;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		List<Set<Character>> rucksacks = new ArrayList<>();
		reinitializeRucksacks(rucksacks);

		int sum = calcSumOfRucksackGroupsItemValues(inputLines, rucksacks);
		System.out.println(sum);
	}

	private int calcSumOfRucksackGroupsItemValues(List<String> inputLines, List<Set<Character>> rucksacks) {
		int sum = 0;

		int i = 0;
		for (String line : inputLines) {
			fillRucksackWithItems(line, rucksacks.get(i++));

			if (i == NUM_OF_RUCKSACKS) {
				sum += calcRucksacksIntersectionValue(rucksacks);
				reinitializeRucksacks(rucksacks);

				i = 0;
			}
		}

		return sum;
	}

	private int calcRucksacksIntersectionValue(List<Set<Character>> rucksacks) {
		Set<Character> intersectionOfRucksacks = intersectRucksacks(rucksacks);
		return calcValueOfItems(intersectionOfRucksacks);
	}

	private static int calcValueOfItems(Set<Character> intersectionOfRucksacks) {
		return intersectionOfRucksacks.stream()
			.map(Item::new)
			.map(Item::getValue)
			.reduce(Integer::sum)
			.orElse(0);
	}

	private static Set<Character> intersectRucksacks(List<Set<Character>> rucksacks) {
		Set<Character> intersection = new HashSet<>(rucksacks.get(0));
		for (int i = 1; i < NUM_OF_RUCKSACKS; i++) {
			intersection.retainAll(rucksacks.get(i));
		}
		return intersection;
	}

	private void reinitializeRucksacks(List<Set<Character>> rucksacks) {
		rucksacks.clear();

		for (int i = 0; i < NUM_OF_RUCKSACKS; i++) {
			rucksacks.add(new HashSet<>());
		}
	}

	private static void fillRucksackWithItems(String line, Set<Character> rucksack) {
		char[] chars = line.toCharArray();
		for (char aChar : chars) {
			rucksack.add(aChar);
		}
	}
}
