package hu.szeredniklaszlo.solutions.s02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpponentSelection {
	A(1), B(2), C(3);

	private final int value;
	public OpponentSelection getWeaker() {
		int weakerValue = value - 1;

		if (weakerValue == 0) {
			weakerValue = 3;
		}

		for (var selection : OpponentSelection.values()) {
			if (selection.value == weakerValue) {
				return selection;
			}
		}

		throw new RuntimeException("No weaker selection for " + this);
	}

	public OpponentSelection getStronger() {
		int strongerValue = value + 1;

		if (strongerValue == 4) {
			strongerValue = 1;
		}

		for (var selection : OpponentSelection.values()) {
			if (selection.value == strongerValue) {
				return selection;
			}
		}

		throw new RuntimeException("No stronger selection for " + this);
	}
}
