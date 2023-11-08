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
	id("org.flywaydb.flyway") version "10.0.0"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

flyway {
	url = "jdbc:postgresql://localhost:5432/dungeons"
	user = "postgres"
	password = "postgres"
	driver = "org.postgresql.Driver"
	locations = arrayOf("filesystem:./src/main/resources/db/migration")
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
	implementation("org.springframework.modulith:spring-modulith-starter-jpa") // includes core https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/#appendix.artifacts
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// integrations
	implementation("org.jmolecules:kmolecules-ddd:1.9.0")
	implementation("org.jmolecules.integrations:jmolecules-spring:1.6.0")
	implementation("org.jmolecules.integrations:jmolecules-jpa:1.6.0")
	compileOnly("org.jmolecules.integrations:jmolecules-bytebuddy-nodep:0.17.0")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

	// observability
	//runtime("org.springframework.modulith:spring-modulith-starter-insight") includes actuator and obs modules
	//implementation("org.springframework.boot:spring-boot-starter-actuator") // watch module interaction at runtime

	// db evolution & pg driver
	implementation("org.flywaydb:flyway-core:10.0.0")
	implementation("org.flywaydb:flyway-database-postgresql:10.0.0")
	implementation("org.postgresql:postgresql:42.2.27")


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