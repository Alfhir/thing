package com.example.demo.dungeon.internal

import org.jmolecules.ddd.types.AggregateRoot
import org.jmolecules.ddd.types.Identifier
import java.util.*

@JvmInline
value class DungeonIdentifier(val id: UUID = UUID.randomUUID()): Identifier {
    fun of(id: UUID)  = DungeonIdentifier(id)
}

data class Dungeon(
    override val id: DungeonIdentifier = DungeonIdentifier(),
) : AggregateRoot<Dungeon, DungeonIdentifier>
