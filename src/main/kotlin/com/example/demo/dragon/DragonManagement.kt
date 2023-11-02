package com.example.demo.dragon

import com.example.demo.dragon.internal.DragonInternal
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class DragonManagement(
    val events: ApplicationEventPublisher,
    val dependency: DragonInternal
){
    @Transactional
    fun complete(dragon: Dragon) {
        events.publishEvent(DragonCreated(dragon.id))
    }
}
