package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dragon
import org.jmolecules.ddd.annotation.Service
import org.springframework.context.ApplicationEventPublisher
import org.springframework.transaction.annotation.Transactional

@Service
open class DungeonManagement(val events: ApplicationEventPublisher) {
    @Transactional
    open fun createDragon(dto: DragonDtoIn) {
        val dragon = Dragon(color = dto.color)
        events.publishEvent(DragonCreated(dragon.id))
    }
}
