package MyCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class CommandActionListener implements ActionListener {

    private boolean start;
    private final JButton display;
    private String lastCommand;

    public CommandActionListener(final boolean start, final JButton display, final String lastCommand) {

        this.start = start;
        this.display = display;
        this.lastCommand = lastCommand;

    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final String command = event.getActionCommand();

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {
        }

        // Füge den Präfix "-" an den String an wenn
        // es sich um den ersten Befehl handelt (negative Zahl)
        if (this.start) {
            if (command.equals("-")) {
                this.display.setText(command);
                this.start = false;
            } else {

                this.lastCommand = command;
            }
        } else {
            // Berechnung ausführen
            // nwe Co.calculate(Double.parseDouble(this.display.getText()));
            this.lastCommand = command;
            this.start = true;
        }
    }
}