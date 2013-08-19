package MyCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for numbers to store.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class InsertActionListener implements ActionListener {

    private final Controller controller;

    InsertActionListener(final Controller controller) {

        this.controller = controller;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final Pojo pojo = this.controller.getPojo();

        final String input = event.getActionCommand();

        if (pojo.isStart()) {
            pojo.setDisplayText("");
            pojo.setStart(false);
        }
        pojo.setDisplayText(pojo.getDisplayText() + input);
    }
}
