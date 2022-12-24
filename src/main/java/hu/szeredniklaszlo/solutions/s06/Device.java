package hu.szeredniklaszlo.solutions.s06;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Device {

	private final int chunkSize;

	private final LinkedList<Character> dataStream;
	private List<Character> dataChunk;
	private int lastChar;

	public Device(String dataStream, int chunkSize) {
		this.chunkSize = chunkSize;
		this.dataStream = dataStream.chars()
			.mapToObj(c -> (char) c)
			.collect(Collectors.toCollection(LinkedList::new));

		readFirstChunk();
	}

	public int findLastCharOfFirstChunkWithMarker() {
		while (!isChunkDistinct()) {
			scrollDataStream();
		}

		return lastChar;
	}

	private void readFirstChunk() {
		dataChunk = dataStream.subList(0, chunkSize);
		lastChar = chunkSize;
	}

	private void scrollDataStream() {
		++lastChar;
		dataChunk = dataStream.subList(lastChar - chunkSize, lastChar);
	}

	public boolean isChunkDistinct() {
		return dataChunk.stream()
			.distinct()
			.count() == chunkSize;
	}
}
