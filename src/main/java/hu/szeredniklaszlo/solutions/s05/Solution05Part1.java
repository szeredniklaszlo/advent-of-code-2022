package hu.szeredniklaszlo.solutions.s05;

import java.util.List;

import hu.szeredniklaszlo.solutions.AbstractSolution;
import hu.szeredniklaszlo.solutions.s05.Ship.CrateMover;

public class Solution05Part1 extends AbstractSolution {

	@Override
	protected int getTaskNumber() {
		return 5;
	}

	@Override
	protected void processInput(List<String> inputLines) {
		/*
			[M] [H]         [N]
			[S] [W]         [F]     [W] [V]
			[J] [J]         [B]     [S] [B] [F]
			[L] [F] [G]     [C]     [L] [N] [N]
			[V] [Z] [D]     [P] [W] [G] [F] [Z]
			[F] [D] [C] [S] [W] [M] [N] [H] [H]
			[N] [N] [R] [B] [Z] [R] [T] [T] [M]
			[R] [P] [W] [N] [M] [P] [R] [Q] [L]
			 1   2   3   4   5   6   7   8   9
		 */
		Ship ship = new Ship(List.of(
			List.of('R', 'N', 'F', 'V', 'L', 'J', 'S', 'M'),
			List.of('P', 'N', 'D', 'Z', 'F', 'J', 'W', 'H'),
			List.of('W', 'R', 'C', 'D', 'G'),
			List.of('N', 'B', 'S'),
			List.of('M', 'Z', 'W', 'P', 'C', 'B', 'F', 'N'),
			List.of('P', 'R', 'M', 'W'),
			List.of('R', 'T', 'N', 'G', 'L', 'S', 'W'),
			List.of('Q', 'T', 'H', 'F', 'N', 'B', 'V'),
			List.of('L', 'M', 'H', 'Z', 'N', 'F')
		));

		inputLines.forEach(line -> {
			ship.setCrateMover(new CrateMover(line));
			ship.useCrateMover9000();
		});

		System.out.println(ship.getTopCrates());
	}
}
