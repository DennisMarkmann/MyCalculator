package MyCalculator;

import java.util.Observable;

/**
 * POJO to store the application data.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class Pojo extends Observable {

	private final CalculatorFrame frame;
	private String lastCommand = "=";
	private boolean start = true;
	private String displayText = "";

	Pojo(final CalculatorFrame frame) {
		super();
		this.frame = frame;
	}

	public final String getDisplayText() {
		return this.displayText;
	}

	public final void setDisplayText(final String displayText) {
		this.displayText = displayText;
		this.frame.update(this);
		// this.update(displayText);
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

	public void update(final String text) {
		// Markierung, daß sich der Text geändert hat
		super.setChanged();
		// ruft für alle Beobachter die update-Methode auf
		super.notifyObservers(text);

	}
}
