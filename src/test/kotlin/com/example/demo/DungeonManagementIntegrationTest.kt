package com.example.demo

import com.example.demo.dungeon.DragonDtoIn
import com.example.demo.dungeon.DungeonManagement
import com.example.demo.dungeon.internal.Color
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.test.ApplicationModuleTest

@SpringBootTest
class DungeonManagementIntegrationTests {
    @Autowired
    lateinit var gameMaster: DungeonManagement

    @Test
    fun `createsDragon`() {
        gameMaster.createDragon(DragonDtoIn(Color.BLACK))
    }
}

