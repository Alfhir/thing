package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

// Verify the modular structure
class ModularityTests {

    val modules: ApplicationModules = ApplicationModules.of(Application::class.java)

    @Test
    fun verifiesModularStructure() {
        modules.verify()
    }
}

