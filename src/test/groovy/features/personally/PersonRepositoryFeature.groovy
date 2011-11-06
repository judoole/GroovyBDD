package features.personally

import steps.background.AbstractSpringGroovyFeature
import org.junit.Test

class PersonRepositoryFeature extends AbstractSpringGroovyFeature {
    @Test
    void should_be_to_set_multiple_addresses_on_person() {
        Given.person_exists([firstname:"Ole Christian", surname:"Langfjæran"])
        And.the_person_with_name_has_an_address("Ole Christian", "Langfjæran", [street:"street1", postal:"0001", city:"Oslo"])
        And.the_person_with_name_has_an_address("Ole Christian", "Langfjæran", [street:"street2", postal:"0001", city:"Oslo"])
        When.I_retrieve_all_persons()
        Then.the_list_of_retrieved_persons_should_be(1)
        And.the_first_person_in_the_list_should_have_full_name("Ole Christian Langfjæran")
        And.the_first_person_in_the_list_should_have_number_of_addresses(2)
    }
}
