package com.example.demo.dungeon.internal

import org.jmolecules.ddd.types.Entity
import org.jmolecules.ddd.types.Identifier
import java.util.*


@JvmInline
value class DragonIdentifier(val id: UUID = UUID.randomUUID()): Identifier {
    fun of(id: UUID)  = DragonIdentifier(id)
}

data class Dragon(override val id: DragonIdentifier = DragonIdentifier(), val color: Color) :
    Entity<Dungeon, DragonIdentifier>

enum class Color {
RED, BLUE, GREEN, BLACK
}
