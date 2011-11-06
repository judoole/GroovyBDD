package steps.personally

import org.springframework.beans.factory.annotation.Autowired
import personally.PersonRepository
import personally.Person
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PersonRepositorySteps {
    @Autowired PersonRepository repo;
    private List<Person> allPersonsResult

    void I_retrieve_all_persons(){
         allPersonsResult= repo.getAllPersons();
    }

    void the_list_of_retrieved_persons_should_be(int resultSize){
        assertThat(allPersonsResult.size(), equalTo(resultSize));
    }

    void the_first_person_in_the_list_should_have_number_of_addresses(int numberOfAddresses){
        assertThat(allPersonsResult.get(0).addresses.size(), equalTo(numberOfAddresses));
    }

    void the_first_person_in_the_list_should_have_full_name(String fullname){
        assertThat(allPersonsResult.get(0).fullname, equalTo(fullname));
    }
}
