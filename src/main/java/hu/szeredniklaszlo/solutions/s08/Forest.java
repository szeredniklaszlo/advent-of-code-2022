package hu.szeredniklaszlo.solutions.s08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import hu.szeredniklaszlo.solutions.s08.Tree.FromDirection;

public class Forest {
	private final int width;
	private final int height;
	private final Tree[][] trees;

	public Forest(List<String> trees) {
		this.height = trees.size();
		this.width = trees.get(0).length();
		this.trees = new Tree[width][height];

		fillTreesFromInput(trees);
		updateVisibilityOfTrees();
		updateScenicScoreOfTrees();
	}

	private void fillTreesFromInput(List<String> trees) {
		for (int rowNum = 0; rowNum < this.height; rowNum++) {
			String row = trees.get(rowNum);

			for (int columnNum = 0; columnNum < this.width; columnNum++) {
				int treeHeight = Character.getNumericValue(row.charAt(columnNum));
				this.trees[rowNum][columnNum] = new Tree(treeHeight);
			}
		}
	}

	private void updateScenicScoreOfTrees() {
		for (int rowNum = 0; rowNum < height; rowNum++) {
			for (int columnNum = 0; columnNum < width; columnNum++) {
				updateScenicScoreToLeft(rowNum, columnNum);
				updateScenicScoreToTop(rowNum, columnNum);
				updateScenicScoreToBottom(rowNum, columnNum);
				updateScenicScoreToRight(rowNum, columnNum);
			}
		}
	}
	
	private void updateScenicScoreToLeft(int treeRow, int treeColumn) {
		Tree tree = trees[treeRow][treeColumn];

		boolean isViewBlockerFound = false;
		int scenicScore = 0;
		for (int columnNum = treeColumn - 1; columnNum >= 0 && !isViewBlockerFound; columnNum--) {
			Tree neighbor = trees[treeRow][columnNum];

			scenicScore++;
			isViewBlockerFound = neighbor.getHeight() >= tree.getHeight();
		}

		tree.getScenicScore().setLeft(scenicScore);
	}
	
	private void updateScenicScoreToRight(int treeRow, int treeColumn) {
		Tree tree = trees[treeRow][treeColumn];

		boolean isViewBlockerFound = false;
		int scenicScore = 0;
		for (int columnNum = treeColumn + 1; columnNum < width && !isViewBlockerFound; columnNum++) {
			Tree neighbor = trees[treeRow][columnNum];

			scenicScore++;
			isViewBlockerFound = neighbor.getHeight() >= tree.getHeight();
		}

		tree.getScenicScore().setRight(scenicScore);
	}

	private void updateScenicScoreToBottom(int treeRow, int treeColumn) {
		Tree tree = trees[treeRow][treeColumn];

		boolean isViewBlockerFound = false;
		int scenicScore = 0;
		for (int rowNum = treeRow + 1; rowNum < height && !isViewBlockerFound; rowNum++) {
			Tree neighbor = trees[rowNum][treeColumn];

			scenicScore++;
			isViewBlockerFound = neighbor.getHeight() >= tree.getHeight();
		}

		tree.getScenicScore().setBottom(scenicScore);
	}

	private void updateScenicScoreToTop(int treeRow, int treeColumn) {
		Tree tree = trees[treeRow][treeColumn];

		boolean isViewBlockerFound = false;
		int scenicScore = 0;
		for (int rowNum = treeRow - 1; rowNum >= 0 && !isViewBlockerFound; rowNum--) {
			Tree neighbor = trees[rowNum][treeColumn];

			scenicScore++;
			isViewBlockerFound = neighbor.getHeight() >= tree.getHeight();
		}

		tree.getScenicScore().setTop(scenicScore);
	}

	public long countVisibleTrees() {
		return Arrays.stream(this.trees)
			.flatMap(Arrays::stream)
			.filter(Tree::isVisibleFromAnywhere)
			.count();
	}

	public long calcMaxScenicScore() {
		return Arrays.stream(this.trees)
			.flatMap(Arrays::stream)
			.map(tree -> tree.getScenicScore().calculate())
			.max(Comparator.comparingInt(treeHeight -> treeHeight))
			.orElse(0);
	}

	private void updateVisibilityOfTrees() {
		updateVisibilityOfRows();
		updateVisibilityOfColumns();
	}

	private void updateVisibilityOfRows() {
		for (int rowNum = 0; rowNum < this.height; rowNum++) {
			updateVisibilityOfRowFromLeft(rowNum);
			updateVisibilityOfRowFromRight(rowNum);
		}
	}

	private void updateVisibilityOfColumns() {
		for (int columnNum = 0; columnNum < this.height; columnNum++) {
			updateVisibilityOfColumnFromTop(columnNum);
			updateVisibilityOfColumnFromBottom(columnNum);
		}
	}

	private void updateVisibilityOfColumnFromTop(int columnNum) {
		int max = Integer.MIN_VALUE;

		for (int rowNum = 0; rowNum < this.height; rowNum++) {
			max = updateVisibilityOfTree(rowNum, columnNum, max, FromDirection.TOP);
		}
	}

	private void updateVisibilityOfColumnFromBottom(int columnNum) {
		int max = Integer.MIN_VALUE;

		for (int rowNum = this.height - 1; rowNum >= 0; rowNum--) {
			max = updateVisibilityOfTree(rowNum, columnNum, max, FromDirection.BOTTOM);
		}
	}

	private void updateVisibilityOfRowFromLeft(int rowNum) {
		int max = Integer.MIN_VALUE;

		for (int columnNum = 0; columnNum < this.width; columnNum++) {
			max = updateVisibilityOfTree(rowNum, columnNum, max, FromDirection.LEFT);
		}
	}

	private void updateVisibilityOfRowFromRight(int rowNum) {
		int max = Integer.MIN_VALUE;

		for (int columnNum = this.width - 1; columnNum >= 0; columnNum--) {
			max = updateVisibilityOfTree(rowNum, columnNum, max, FromDirection.RIGHT);
		}
	}

	private int updateVisibilityOfTree(int rowNum, int columnNum, int max, FromDirection fromDirection) {
		Tree tree = this.trees[rowNum][columnNum];
		if (tree.getHeight() > max) {
			max = tree.getHeight();
			tree.updateVisibility(fromDirection);
		}

		return max;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				stringBuilder.append(trees[i][j].getHeight());
				stringBuilder.append(' ');
			}

			stringBuilder.append('\n');
		}

		return stringBuilder.toString();
	}
}
