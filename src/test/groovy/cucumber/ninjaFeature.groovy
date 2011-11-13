package cucumber

import org.junit.runner.RunWith
import cucumber.junit.Feature
import cucumber.junit.Cucumber

@RunWith(Cucumber.class)
@Feature(value = "ninja.feature")
class ninjaFeature {
}
