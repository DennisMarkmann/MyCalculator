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
    private Pojo pojo;
    private double result = 0;

    final void createGui() {

        this.frame = new CalculatorFrame(this);
        this.pojo = new Pojo(this.frame);
    }

    final void calculate(final double x) {

        final String lastCommand = this.pojo.getLastCommand();

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
        this.pojo.setDisplayText(this.result + "");
    }

    public final Pojo getPojo() {
        return this.pojo;
    }
}
