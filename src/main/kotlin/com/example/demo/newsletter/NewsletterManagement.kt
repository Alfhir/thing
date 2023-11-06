package com.example.demo.newsletter

import com.example.demo.dungeon.DragonCreated
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.modulith.ApplicationModuleListener
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class NewsletterManagement {
    @ApplicationModuleListener
    @Throws(InterruptedException::class)
    fun on(event: DragonCreated) {
        val monsterId = event.dragonId.id
        logger.info { "Received dragon creation (ID = $monsterId)." }
        // simulate work
        Thread.sleep(1000)
        logger.info { "Finished publishing dragon creation (ID = $monsterId)." }
    }
}

