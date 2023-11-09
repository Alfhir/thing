package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dungeon
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestPropertySource

@TestPropertySource(locations= ["classpath:application-test.yaml"])
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class RepositoriesTests{
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var dungeonsRepository: Dungeons

    @Test
    fun `when save then return entity`() {
        val dungeon = Dungeon()
        entityManager.persist(dungeon)
        entityManager.flush()
        val saved = dungeonsRepository.save(dungeon)
        assertThat(dungeon).isEqualTo(saved)
    }
}