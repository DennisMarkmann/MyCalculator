package MyCalculator;

/**
 * POJO to store the application data.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class Pojo {

	private final CalculatorFrame frame;
	private String lastCommand = "=";
	private boolean start = true;
	private String displayText = "";

	Pojo(final CalculatorFrame frame) {
		this.frame = frame;
	}

	public final String getDisplayText() {
		return this.displayText;
	}

	public final void setDisplayText(final String displayText) {
		this.displayText = displayText;
		this.frame.setDisplayText(displayText);
	}

	public final String getLastCommand() {
		return this.lastCommand;
	}

	public final void setLastCommand(final String lastCommand) {
		this.lastCommand = lastCommand;
	}

	public final boolean isStart() {
		return this.start;
	}

	public final void setStart(final boolean start) {
		this.start = start;
	}
}
