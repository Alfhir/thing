package com.example.demo

import com.example.demo.dungeon.Dungeons
import com.example.demo.dungeon.internal.Dungeon
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@Component
class ApplicationRunner(private val repository: Dungeons) : org.springframework.boot.ApplicationRunner {

	override fun run(args: ApplicationArguments?) {
		saveDungeon()
	}

	private fun saveDungeon() = repository.save(Dungeon()).also(::println)
}
