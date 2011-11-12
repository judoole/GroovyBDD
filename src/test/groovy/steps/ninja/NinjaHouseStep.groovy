package steps.ninja

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import ninja.NinjaHouse
import ninja.Weapon
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import static factory.ObjectFactory.ninjaHouse
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

@Component
class NinjaHouseStep {
    @PersistenceContext
    private EntityManager em;
    private NinjaHouse ninjaHouseOnStep

    @Transactional
    void ninja_house_exists(Object house) {
        this.ninjaHouseOnStep = new NinjaHouse(house)
        em.persist(ninjaHouseOnStep);
    }

    @Transactional
    void et_ninjahus_eksisterer(Object hus = null) {
        this.ninjaHouseOnStep = hus == null ? ninjaHouse() : new NinjaHouse(hus)
        em.persist(ninjaHouseOnStep);
    }

    @Transactional
    void ninja_huset_blir_odelagt_med(Weapon weapon) {
        getNinjaHouse(ninjaHouseOnStep.name).destroy(weapon);
    }

    @Transactional
    void skal_ninjahuset_være_ødelagt(String navn_paa_hus = null) {
        String navnPaaHuset = navn_paa_hus == null ? ninjaHouseOnStep.name : navn_paa_hus;
        NinjaHouse n = getNinjaHouse(navnPaaHuset)
        assertThat(n.destroyed, equalTo(true));
    }

    private NinjaHouse getNinjaHouse(String navn_paa_hus) {
        def list = em.createQuery("from NinjaHouse").resultList;
        return em.createQuery("from NinjaHouse where name=?").setParameter(1, navn_paa_hus).singleResult
    }
}
