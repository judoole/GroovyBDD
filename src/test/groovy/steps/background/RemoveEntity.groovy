package steps.background

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class RemoveEntity {
    @Autowired JdbcTemplate jdbcTemplate

    @Transactional
    void allEntities() {
        jdbcTemplate.execute("update Ninja set ninjaHouse_id=null")
        jdbcTemplate.execute("delete from NinjaHouse_ninja")
        jdbcTemplate.execute("delete from NinjaHouse")
        jdbcTemplate.execute("delete from Ninja")
    }
}
