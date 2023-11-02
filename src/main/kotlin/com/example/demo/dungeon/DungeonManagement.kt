package com.example.demo.dungeon

import com.example.demo.dragon.DragonCreated
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.modulith.ApplicationModuleListener
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class DungeonManagement (private val dependency: DungeonInternal){

    @ApplicationModuleListener
    @Throws(InterruptedException::class)
    fun on(event: DragonCreated) {
        val monsterId = event.dragonId.id
        logger.info { "Received monster creation for $monsterId." }
        // simulate work
        Thread.sleep(1000)
        logger.info { "Finished monster creation for $monsterId." }
    }
}

