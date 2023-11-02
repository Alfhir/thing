package com.example.demo.dungeon

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties


@EnableConfigurationProperties(DungeonParentProperties::class)
class DungeonConfiguration

@ConfigurationProperties(prefix = "com.example.demo.dungeon")
class DungeonParentProperties(
    val dimensions: Dimensions= Dimensions(1.meter, 1.meter, 1.meter)){
    class Dimensions(val length: Meter, val width: Meter, val height: Meter){

    }
}

@JvmInline
value class Meter private constructor(val value: Int) {
    companion object {
        fun of(value: Int): Meter {
            require(value >= 0)
            return Meter(value)
        }
    }
}

inline val Int.meter: Meter get() = Meter.of(this)


