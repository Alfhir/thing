package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

class DocumentationTest {

    val modules: ApplicationModules = ApplicationModules.of(Application::class.java)

    @Test
    fun createModuleDocumentation() {
        Documenter(modules)
            .writeDocumentation()
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml()
    }
}