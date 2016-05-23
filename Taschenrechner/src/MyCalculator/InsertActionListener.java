package MyCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for numbers to store.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class InsertActionListener implements ActionListener {

    private final Controller controller;

    InsertActionListener(final Controller controller) {

        this.controller = controller;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final Model model = this.controller.getModel();

        final String input = event.getActionCommand();

        // if (model.isStart()) {
        // model.setDisplayText("");
        // model.setStart(false);
        // }
        model.setDisplayText(model.getDisplayText() + input);
    }
}
