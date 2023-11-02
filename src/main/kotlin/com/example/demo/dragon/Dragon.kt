package com.example.demo.dragon

import org.jmolecules.ddd.types.AggregateRoot
import org.jmolecules.ddd.types.Identifier
import java.util.*

@JvmInline
value class DragonIdentifier(val id: UUID = UUID.randomUUID()): Identifier

data class Dragon(private val dragonIdentifier: DragonIdentifier = DragonIdentifier()) : AggregateRoot<Dragon, DragonIdentifier> {
    override fun getId(): DragonIdentifier = this.dragonIdentifier
}