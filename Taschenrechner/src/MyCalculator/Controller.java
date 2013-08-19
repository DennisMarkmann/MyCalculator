package MyCalculator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Controller {

    public void createGui() {
        final CalculatorGui gui = new CalculatorGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    public void calculate(final double x, final String lastCommand, final JButton display) {

        double result = 0;

        if (lastCommand.equals("+")) {
            result += x;
        } else if (lastCommand.equals("-")) {
            result -= x;
        } else if (lastCommand.equals("*")) {
            result *= x;
        } else if (lastCommand.equals("/")) {
            result /= x;
        } else if (lastCommand.equals("=")) {
            result = x;
        }
        // this.display.setText("" + this.result);
    }

}
