package hu.szeredniklaszlo.solutions.s05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Ship {
	private final List<Stack<Character>> stacks = new ArrayList<>();
	private CrateMover crateMover;

	public Ship(List<List<Character>> characterLists) {
		for (List<Character> characterList : characterLists) {
			Stack<Character> stack = new Stack<>();
			characterList.forEach(stack::push);
			stacks.add(stack);
		}
	}

	public void useCrateMover9000() {
		Stack<Character> fromStack = stacks.get(crateMover.from);
		Stack<Character> toStack = stacks.get(crateMover.to);

		for (int i = 0; i < crateMover.move; i++) {
			Character charGrabbed = fromStack.pop();
			toStack.push(charGrabbed);
		}
	}

	public void useCrateMover9001() {
		Stack<Character> fromStack = stacks.get(crateMover.from);
		Stack<Character> toStack = stacks.get(crateMover.to);

		Stack<Character> inverter = new Stack<>();
		for (int i = 0; i < crateMover.move; i++) {
			Character charGrabbed = fromStack.pop();
			inverter.push(charGrabbed);
		}

		for (int i = 0; i < crateMover.move; i++) {
			Character charGrabbed = inverter.pop();
			toStack.push(charGrabbed);
		}
	}

	public String getTopCrates() {
		return stacks.stream()
			.map(Stack::peek)
			.map(String::valueOf)
			.collect(Collectors.joining());
	}

	public static class CrateMover {
		private final int move;
		private final int from;
		private final int to;

		public CrateMover(String instruction) {
			String[] instructions = instruction.split(" ");
			move = Integer.parseInt(instructions[1]);
			from = Integer.parseInt(instructions[3]) - 1;
			to = Integer.parseInt(instructions[5]) - 1;
		}
	}
}
