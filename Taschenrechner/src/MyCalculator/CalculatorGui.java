package MyCalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creates a small calculator.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

public class CalculatorGui extends JFrame {

    private final JButton display;
    private final JPanel panel;
    private final String lastCommand;
    private final boolean start;

    public CalculatorGui() {
        this.setTitle("Calculator");
        this.setLayout(new BorderLayout());

        this.lastCommand = "=";
        this.start = true;

        this.display = new JButton("0");
        this.display.setEnabled(false);
        this.add(this.display, BorderLayout.NORTH);

        final ActionListener insert = new InsertActionListener();
        final ActionListener command = new CommandActionListener(this.start, this.display, this.lastCommand);

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
    }

    private void addButton(final String label, final ActionListener listener) {
        final JButton button = new JButton(label);
        button.addActionListener(listener);
        this.panel.add(button);
    }

    // private class InsertAction implements ActionListener {
    //
    // @Override
    // public void actionPerformed(final ActionEvent event) {
    // final String input = event.getActionCommand();
    // if (CalculatorPanel.this.start) {
    // CalculatorPanel.this.display.setText("");
    // CalculatorPanel.this.start = false;
    // }
    // CalculatorPanel.this.display.setText(CalculatorPanel.this.display.getText() + input);
    // }
    // }

    public void setResult(final double result) {
        this.display.setText("" + result);
    }

}
