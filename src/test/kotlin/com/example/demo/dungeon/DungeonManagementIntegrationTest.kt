package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Color
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DungeonManagementIntegrationTests {
    @Autowired
    lateinit var gameMaster: DungeonManagement

    @Test
    fun `createsDragon`() {
        gameMaster.createDragon(DragonDtoIn(Color.BLACK))
    }
}

