package com.example.demo.dungeon

import com.example.demo.dungeon.internal.DragonIdentifier
import org.jmolecules.event.types.DomainEvent

data class DragonCreated(val dragonId: DragonIdentifier): DomainEvent

