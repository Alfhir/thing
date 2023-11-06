package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dragon
import org.jmolecules.ddd.annotation.Service
import org.springframework.context.ApplicationEventPublisher
import org.springframework.transaction.annotation.Transactional

@Service
class DungeonManagement(val events: ApplicationEventPublisher) {
    @Transactional
    fun createDragon(dto: DragonDtoIn) {
        val dragon = Dragon(color = dto.color)
        events.publishEvent(DragonCreated(dragon.id))
    }
}
