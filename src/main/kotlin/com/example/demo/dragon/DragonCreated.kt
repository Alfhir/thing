package com.example.demo.dragon

import org.jmolecules.event.types.DomainEvent

data class DragonCreated(val dragonId: DragonIdentifier): DomainEvent

