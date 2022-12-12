package hu.szeredniklaszlo.solutions.s03;

import lombok.Getter;

@Getter
public class Item {
	private final int value;

	public Item(Character character) {
		if (character == null) {
			this.value = 0;
			return;
		}

		int charValue = character;
		if (charValue >= 'a' && charValue <= 'z') {
			this.value = charValue - 'a' + 1;
		} else if (charValue >= 'A' && charValue <= 'Z') {
			this.value = charValue - 'A' + 27;
		} else {
			this.value = 0;
		}
	}
}
