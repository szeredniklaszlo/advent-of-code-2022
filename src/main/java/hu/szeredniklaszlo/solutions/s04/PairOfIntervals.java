package hu.szeredniklaszlo.solutions.s04;

import lombok.Data;

@Data
public class PairOfIntervals {
	private Interval interval1;
	private Interval interval2;

	public PairOfIntervals(String pair) {
		String[] intervals = pair.split(",");
		interval1 = new Interval(intervals[0]);
		interval2 = new Interval(intervals[1]);
	}

	public boolean doesOneIntervalFullyContainTheOther() {
		return interval1.doesFullyContain(interval2) || interval2.doesFullyContain(interval1);
	}

	public boolean doesIntervalsOverlap() {
		return interval1.doesOverlap(interval2);
	}

	@Data
	public static class Interval {
		private int start;
		private int end;

		public Interval(String interval) {
			String[] boundaries = interval.split("-");

			start = Integer.parseInt(boundaries[0]);
			end = Integer.parseInt(boundaries[1]);
		}

		public boolean doesFullyContain(Interval that) {
			return this.start <= that.start && this.end >= that.end;
		}

		public boolean doesOverlap(Interval that) {
			return this.start <= that.end && this.end >= that.start;
		}
	}
}
