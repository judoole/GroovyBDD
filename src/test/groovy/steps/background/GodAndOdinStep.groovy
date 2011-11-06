package steps.background

import calculator.DateCalculator
import steps.calculator.DateCalculatorSteps
import org.springframework.beans.factory.annotation.Autowired
import steps.PersonStep
import org.springframework.stereotype.Component
import steps.personally.PersonRepositorySteps

@Component
class GodAndOdinStep {
    @Delegate
    protected DateCalculatorSteps dateCalculatorSteps = new DateCalculatorSteps();
    @Autowired
    @Delegate
    PersonStep personStep;
    @Autowired
    @Delegate
    PersonRepositorySteps personRepositorySteps;;
}
