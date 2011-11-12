package steps.calculator

import calculator.DateCalculator
import static org.hamcrest.core.IsEqual.equalTo
import static org.junit.Assert.assertThat

class DateCalculatorSteps {
    DateCalculator calculator;
    String result

    void today_is(String date){
        calculator = new DateCalculator(Date.parse("yyyy-MM-dd", date))
    }

    void I_ask_if_the_date_is_in_the_past_for(String date){
        result = calculator.isDateInThePast(Date.parse("yyyy-MM-dd", date))        
    }

    void the_result_from_the_datecalculator_should_be(String answer){
        assertThat(result, equalTo(answer))
    }
}
