package MyCalculator;

/**
 * Controller class for the calculation and initialization.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

class Controller {

    private Model model;

    final void createGui() {

        this.model = new Model();
        this.model.addObserver(new CalculatorFrame(this));
    }

    final void calculate(final double x) {
        double result = 0;

        final String lastCommand = this.model.getLastCommand();

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
        this.model.setDisplayText(result + "");
    }

    public final Model getModel() {
        return this.model;
    }
}
