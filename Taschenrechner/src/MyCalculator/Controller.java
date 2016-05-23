package MyCalculator;

/**
 * Controller class for the calculation and initialization.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class Controller {

    double result;
    private Model model;

    final void createGui() {

        this.model = new Model();
        this.model.addObserver(new CalculatorFrame(this));
    }

    final void calculate(final double x) {

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
