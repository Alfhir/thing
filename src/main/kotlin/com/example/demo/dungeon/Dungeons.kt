package com.example.demo.dungeon

import com.example.demo.dungeon.internal.Dungeon
import com.example.demo.dungeon.internal.DungeonIdentifier
import org.springframework.data.jpa.repository.JpaRepository

@org.jmolecules.ddd.annotation.Repository
interface Dungeons: JpaRepository<Dungeon, DungeonIdentifier>

