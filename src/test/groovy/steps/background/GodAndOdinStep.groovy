package steps.background

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import steps.calculator.DateCalculatorSteps
import steps.ninja.NinjaStep
import steps.ninja.NinjaHouseStep

@Component
class GodAndOdinStep {
    @Delegate
    protected DateCalculatorSteps dateCalculatorSteps = new DateCalculatorSteps();
    @Autowired
    @Delegate
    NinjaStep personStep;
    @Autowired
    @Delegate
    NinjaHouseStep ninjaHouseStep;
}
