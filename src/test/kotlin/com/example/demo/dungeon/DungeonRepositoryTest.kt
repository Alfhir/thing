package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dungeon
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val dungeonsRepository: Dungeons,
    ) {

    @Test
    fun `when save then return entity`() {
        val dungeon = Dungeon()
        entityManager.persist(dungeon)
        entityManager.flush()
        val saved = dungeonsRepository.save(dungeon)
        assertThat(dungeon).isEqualTo(saved)
    }
}