package hu.szeredniklaszlo.solutions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import lombok.SneakyThrows;

public abstract class AbstractSolution implements Runnable {

	private static final String ROOT_DIRECTORY = "./src/main/java/hu/szeredniklaszlo/solutions";
	protected abstract int getTaskNumber();

	private String getInputFilePath() {
		String solutionFolderName;

		int taskNumber = getTaskNumber();
		if (taskNumber < 10) {
			solutionFolderName = "0" + taskNumber;
		} else {
			solutionFolderName = Integer.toString(taskNumber);
		}

		return ROOT_DIRECTORY + "/s" + solutionFolderName + "/input.txt";
	}

	@Override
	@SneakyThrows
	public final void run() {
		try (Stream<String> fileStream = Files.lines(Paths.get(getInputFilePath()))) {
			List<String> inputLines = fileStream.toList();
			processInput(inputLines);
		}
	}

	protected abstract void processInput(List<String> inputLines);
}
