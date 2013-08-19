package MyCalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creates a small calculator GUI.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class CalculatorFrame extends JFrame {

    private static final long serialVersionUID = 7676278257630350672L;

    private final JButton display;
    private final JPanel panel;

    CalculatorFrame(final Controller controller) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        this.display = new JButton("0");
        this.display.setEnabled(false);
        this.add(this.display, BorderLayout.NORTH);

        final ActionListener insert = new InsertActionListener(controller);
        final ActionListener command = new CommandActionListener(controller);

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(4, 4));

        this.addButton("7", insert);
        this.addButton("8", insert);
        this.addButton("9", insert);
        this.addButton("/", command);

        this.addButton("4", insert);
        this.addButton("5", insert);
        this.addButton("6", insert);
        this.addButton("*", command);

        this.addButton("1", insert);
        this.addButton("2", insert);
        this.addButton("3", insert);
        this.addButton("-", command);

        this.addButton("0", insert);
        this.addButton(".", insert);
        this.addButton("=", command);
        this.addButton("+", command);

        this.add(this.panel, BorderLayout.CENTER);
        this.add(this.panel);
        this.pack();
        this.setVisible(true);
    }

    public final void setDisplayText(final String text) {
        this.display.setText(text);
    }

    private void addButton(final String label, final ActionListener listener) {
        final JButton button = new JButton(label);
        button.addActionListener(listener);
        this.panel.add(button);
    }
}