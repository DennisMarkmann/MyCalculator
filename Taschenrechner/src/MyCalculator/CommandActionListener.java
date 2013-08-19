package MyCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for commands to store.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class CommandActionListener implements ActionListener {

    private final Controller controller;

    public CommandActionListener(final Controller controller) {

        this.controller = controller;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final Pojo pojo = this.controller.getPojo();
        final String command = event.getActionCommand();

        // Füge den Präfix "-" an den String an wenn
        // es sich um den ersten Befehl handelt (negative Zahl)
        if (pojo.isStart()) {
            if (command.equals("-")) {
                pojo.setDisplayText(command);
                pojo.setStart(false);
            } else {
                pojo.setLastCommand(command);
            }
        } else {
            this.controller.calculate(Double.parseDouble(pojo.getDisplayText()));
            pojo.setLastCommand(command);
            pojo.setStart(true);
        }
    }
}