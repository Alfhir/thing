import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath(platform("org.jmolecules:jmolecules-bom:2021.1.0"))
		classpath("org.jmolecules.integrations:jmolecules-bytebuddy")
	}
}

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("net.bytebuddy.byte-buddy-gradle-plugin") version "1.14.9"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

byteBuddy {
	transformation{
		plugin = org.jmolecules.bytebuddy.JMoleculesPlugin::class.java
	}
}

group = "com.example.demo"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {

	// starters
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//modulith
	implementation("org.springframework.modulith:spring-modulith-starter-jpa") // includes core

	// jmolecules
	implementation(platform("org.jmolecules:jmolecules-bom:2021.1.0"))
	implementation("org.jmolecules:kmolecules-ddd:1.9.0")
	implementation("org.jmolecules:jmolecules-events")
	implementation("org.jmolecules.integrations:jmolecules-spring")
	implementation("org.jmolecules.integrations:jmolecules-jpa")
	compileOnly("org.jmolecules.integrations:jmolecules-bytebuddy")

	// thymeleaf spring security integration
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

	// observability
	//runtime("org.springframework.modulith:spring-modulith-starter-insight")
	//implementation("org.springframework.boot:spring-boot-starter-actuator")

	// flyway & pg driver as provided by start.spring.io
	// implementation("org.flywaydb:flyway-core")
	runtimeOnly("org.postgresql:postgresql")

	// htmx
	implementation("org.webjars.npm:htmx.org:1.9.6")

	// logging
	implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")

	// testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.modulith:spring-modulith-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.modulith:spring-modulith-bom:1.0.2")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}