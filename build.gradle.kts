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
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.modulith:spring-modulith-starter-jpa") // includes core

	implementation(platform("org.jmolecules:jmolecules-bom:2021.1.0"))
	implementation("org.jmolecules:kmolecules-ddd:1.9.0")
	implementation("org.jmolecules:jmolecules-events")
	implementation("org.jmolecules.integrations:jmolecules-spring")
	implementation("org.jmolecules.integrations:jmolecules-jpa")

	compileOnly("org.jmolecules.integrations:jmolecules-bytebuddy")

	runtimeOnly("org.postgresql:postgresql")

	// observability
	//runtime("org.springframework.modulith:spring-modulith-starter-insight")
	//implementation("org.springframework.boot:spring-boot-starter-actuator")

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