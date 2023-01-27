package hu.szeredniklaszlo.solutions.s09.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Command {
	protected final int value;
	protected final int cost;
}
