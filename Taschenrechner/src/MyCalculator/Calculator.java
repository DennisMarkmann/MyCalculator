package MyCalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Erstellt einen kleinen Taschenrechner.
 * 
 * @version 1.00 2005-09-03
 * @author GAGA
 * @link http://www.codeplanet.eu/
 */
public class Calculator {

    public static void main(final String[] args) {
        final CalculatorFrame frame = new CalculatorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        this.setTitle("Calculator");
        final CalculatorPanel panel = new CalculatorPanel();
        this.add(panel);
        this.pack();
    }
}

class CalculatorPanel extends JPanel {

    public CalculatorPanel() {
        this.setLayout(new BorderLayout());

        this.result = 0;
        this.lastCommand = "=";
        this.start = true;

        this.display = new JButton("0");
        this.display.setEnabled(false);
        this.add(this.display, BorderLayout.NORTH);

        final ActionListener insert = new InsertAction();
        final ActionListener command = new CommandAction();

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
    }

    private void addButton(final String label, final ActionListener listener) {
        final JButton button = new JButton(label);
        button.addActionListener(listener);
        this.panel.add(button);
    }

    private class InsertAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent event) {
            final String input = event.getActionCommand();
            if (CalculatorPanel.this.start) {
                CalculatorPanel.this.display.setText("");
                CalculatorPanel.this.start = false;
            }
            CalculatorPanel.this.display.setText(CalculatorPanel.this.display.getText() + input);
        }
    }

    /**
     * Diese Aktion führt den mit der Taste verbundenen Befehl aus.
     */
    private class CommandAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent event) {
            final String command = event.getActionCommand();

            // Füge den Präfix "-" an den String an wenn
            // es sich um den ersten Befehl handelt (negative Zahl)
            if (CalculatorPanel.this.start) {
                if (command.equals("-")) {
                    CalculatorPanel.this.display.setText(command);
                    CalculatorPanel.this.start = false;
                } else {
                    CalculatorPanel.this.lastCommand = command;
                }
            } else {
                // Berechnung ausführen
                CalculatorPanel.this.calculate(Double.parseDouble(CalculatorPanel.this.display.getText()));
                CalculatorPanel.this.lastCommand = command;
                CalculatorPanel.this.start = true;
            }
        }
    }

    /**
     * Führt die anstehenden Berechnungen aus.
     * 
     * @param x der mit dem vorherigen Ergebnis zu berechnende Wert
     */
    public void calculate(final double x) {
        if (this.lastCommand.equals("+")) {
            this.result += x;
        } else if (this.lastCommand.equals("-")) {
            this.result -= x;
        } else if (this.lastCommand.equals("*")) {
            this.result *= x;
        } else if (this.lastCommand.equals("/")) {
            this.result /= x;
        } else if (this.lastCommand.equals("=")) {
            this.result = x;
        }
        this.display.setText("" + this.result);
    }

    private final JButton display;
    private final JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
}