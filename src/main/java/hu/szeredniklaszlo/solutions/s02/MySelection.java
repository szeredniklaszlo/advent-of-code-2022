package hu.szeredniklaszlo.solutions.s02;

import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MySelection {
	X(1), Y(2), Z(3);

	private final int value;

	private static final Map<Integer, MySelection> mySelectionByValueMap = Map.ofEntries(
		Map.entry(1, X),
		Map.entry(2, Y),
		Map.entry(3, Z)
	);

	public static MySelection valueOf(int value) {
		return mySelectionByValueMap.get(value);
	}
}
