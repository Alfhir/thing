package com.example.demo

import com.example.demo.dungeon.internal.Dungeon
import com.example.demo.dungeon.internal.Dungeons
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	val applicationContext = runApplication<Application>(*args)
	val repository = applicationContext.getBean(Dungeons::class.java);
	val dungeon = repository.save(Dungeon());
}
