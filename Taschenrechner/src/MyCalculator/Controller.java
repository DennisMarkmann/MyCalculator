package MyCalculator;

/**
 * Controller class for the calculation and initialization.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class Controller {

    private CalculatorFrame frame;
    private Model model;
    private double result = 0;

    final void createGui() {

        this.frame = new CalculatorFrame(this);
        this.model = new Model();
        this.model.addObserver(this.frame);
    }

    final void calculate(final double x) {

        final String lastCommand = this.model.getLastCommand();

        if (lastCommand.equals("+")) {
            this.result += x;
        } else if (lastCommand.equals("-")) {
            this.result -= x;
        } else if (lastCommand.equals("*")) {
            this.result *= x;
        } else if (lastCommand.equals("/")) {
            this.result /= x;
        } else if (lastCommand.equals("=")) {
            this.result = x;
        }
        this.model.setDisplayText(this.result + "");
    }

    public final Model getModel() {
        return this.model;
    }
}
