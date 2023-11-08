package com.example.demo.dungeon.internal

import org.springframework.data.repository.CrudRepository

interface Dungeons: CrudRepository<Dungeon, DungeonIdentifier>

