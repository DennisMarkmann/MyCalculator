package MyCalculator;

import java.util.Observable;

/**
 * POJO to store the application data.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class Model extends Observable {

    private String lastCommand = "=";
    private boolean start = true;
    private String displayText = "";

    public final String getDisplayText() {
        return this.displayText;
    }

    public final void setDisplayText(final String displayText) {
        this.displayText = displayText;
        this.update(displayText);
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

    private void update(final String text) {
        super.setChanged();
        super.notifyObservers(text);
    }
}
