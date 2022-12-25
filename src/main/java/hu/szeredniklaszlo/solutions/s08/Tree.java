package hu.szeredniklaszlo.solutions.s08;

import lombok.Data;
import lombok.Getter;

public class Tree {
	@Getter
	private final Visibility visibility = new Visibility();

	@Getter
	private final ScenicScore scenicScore = new ScenicScore();

	@Getter
	private final int height;

	public Tree(int height) {
		this.height = height;
	}

	public boolean isVisibleFromAnywhere() {
		return visibility.bottom || visibility.top || visibility.left || visibility.right;
	}

	public void updateVisibility(FromDirection fromDirection) {
		switch (fromDirection) {
			case LEFT -> this.getVisibility().setLeft(true);
			case RIGHT -> this.getVisibility().setRight(true);
			case TOP -> this.getVisibility().setTop(true);
			case BOTTOM -> this.getVisibility().setBottom(true);
		}
	}

	public enum FromDirection {
		LEFT, RIGHT, TOP, BOTTOM;
	}

	@Data
	public static class Visibility {
		private boolean top;
		private boolean bottom;
		private boolean left;
		private boolean right;
	}

	@Data
	public static class ScenicScore {
		private int top;
		private int bottom;
		private int left;
		private int right;

		public int calculate() {
			return top * bottom * left * right;
		}
	}
}
