package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dungeon
import com.example.demo.dungeon.internal.DungeonIdentifier
import org.springframework.data.repository.CrudRepository

@org.jmolecules.ddd.annotation.Repository
interface Dungeons: CrudRepository<Dungeon, DungeonIdentifier>

