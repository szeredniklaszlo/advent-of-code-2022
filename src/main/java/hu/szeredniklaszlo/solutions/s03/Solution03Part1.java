package hu.szeredniklaszlo.solutions.s03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.szeredniklaszlo.solutions.AbstractSolution;

public class Solution03Part1 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 3;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		int sum = 0;

		for (String line : inputLines) {
			Set<Character> rucksack1 = new HashSet<>();
			Set<Character> rucksack2 = new HashSet<>();

			fillRucksackWithItems(line, rucksack1, rucksack2);

			Set<Character> intersection = new HashSet<>(rucksack1);
			intersection.retainAll(rucksack2);

			for (Character c : intersection) {
				Item item = new Item(c);
				sum += item.getValue();
			}
		}

		System.out.println(sum);
	}

	private static void fillRucksackWithItems(String line, Set<Character> rucksack1, Set<Character> rucksack2) {
		char[] chars = line.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length / 2) {
				rucksack1.add(chars[i]);
			} else {
				rucksack2.add(chars[i]);
			}
		}
	}
}
