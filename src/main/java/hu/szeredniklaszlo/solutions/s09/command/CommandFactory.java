package hu.szeredniklaszlo.solutions.s09.command;

public abstract class CommandFactory {
	public static Command createCommand(String command) {
		String[] commandArgs = command.split(" ");

		if ("addx".equals(commandArgs[0])) {
			return new AddCommand(Integer.parseInt(commandArgs[1]));
		} else if ("noop".equals(commandArgs[0])) {
			return new NoopCommand();
		}

		throw new CommandNotImplementedException(commandArgs[0]);
	}

	private static class CommandNotImplementedException extends RuntimeException {
		public CommandNotImplementedException(String commandName) {
			super(String.format("Command name: %s", commandName));
		}
	}
}
