import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("net.bytebuddy.byte-buddy-gradle-plugin") version "1.14.9"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
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
	implementation("org.springframework.modulith:spring-modulith-starter-jpa") // includes core https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/#appendix.artifacts
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// integrations
	implementation("org.jmolecules:kmolecules-ddd:1.9.0")
	implementation("org.jmolecules.integrations:jmolecules-spring:1.6.0")
	implementation("org.jmolecules.integrations:jmolecules-bytebuddy:1.6.0")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

	// observability
	//runtime("org.springframework.modulith:spring-modulith-starter-insight") includes actuator and obs modules
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	// persistence
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.flywaydb:flyway-core")
	runtimeOnly("com.h2database:h2")

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