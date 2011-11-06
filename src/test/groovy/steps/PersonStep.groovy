package steps

import org.springframework.stereotype.Component
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import org.springframework.transaction.annotation.Transactional
import personally.Person
import personally.Address

@Component
class PersonStep {
    @PersistenceContext
    EntityManager em;

    @Transactional
    void person_exists(Object person){
        Person p = new Person(person);
        em.merge(p);
    }
    @Transactional
    void the_person_with_name_has_an_address(String firstname, String surname, Object address){
        Person person = em.createQuery("from Person where firstname=? and surname=?", Person.class).setParameter(1, firstname).setParameter(2, surname).getSingleResult();
        person.addresses.add(new Address(address));
    }
}
