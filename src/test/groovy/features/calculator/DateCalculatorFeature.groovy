package features.calculator

import org.junit.Test
import steps.background.AbstractGroovyFeature

class DateCalculatorFeature extends AbstractGroovyFeature{
    @Test
    void shouldBeAbleToFormatNumbers(){
        Given.today_is("2011-11-04")
        When.I_ask_if_the_date_is_in_the_past_for("2011-1-1")
        Then.the_result_from_the_datecalculator_should_be("yes")
    }
}
