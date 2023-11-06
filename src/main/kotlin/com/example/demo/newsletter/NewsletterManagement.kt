package com.example.demo.newsletter

import com.example.demo.dungeon.DragonCreated
import io.github.oshai.kotlinlogging.KotlinLogging
import org.jmolecules.ddd.annotation.Service
import org.springframework.modulith.ApplicationModuleListener

private val logger = KotlinLogging.logger {}

@Service
open class NewsletterManagement {
    @ApplicationModuleListener
    @Throws(InterruptedException::class)
    open fun on(event: DragonCreated) {
        val monsterId = event.dragonId.id
        logger.info { "Received dragon creation (ID = $monsterId)." }
        // simulate work
        Thread.sleep(1000)
        logger.info { "Finished publishing dragon creation (ID = $monsterId)." }
    }
}

