package steps.background

import calculator.DateCalculator
import steps.calculator.DateCalculatorSteps

class GodAndOdinStep {
    @Delegate
    protected DateCalculatorSteps dateCalculatorSteps = new DateCalculatorSteps();
}
