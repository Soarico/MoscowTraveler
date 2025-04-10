plugins {
    kotlin("jvm") version "2.0.10"
    id("org.springframework.boot") version "3.3.5"
    kotlin("plugin.spring") version "1.9.23"
    id("com.bmuschko.docker-spring-boot-application") version "9.4.0"
    kotlin("plugin.jpa") version "1.9.25"
    jacoco
}

group = "MoscowTraveler"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.3.6"))
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.4"))

    implementation ("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    implementation("jakarta.transaction:jakarta.transaction-api:2.0.0")

    implementation("org.hibernate.orm:hibernate-core:5.6.10.Final")
    implementation("com.h2database:h2:1.4.200")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("io.mockk:mockk:1.13.8")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.8.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.8.0")
    testImplementation("io.kotest:kotest-property-jvm:5.8.0")

    runtimeOnly("com.h2database:h2")
}

kotlin {
    jvmToolchain(17)
}

docker {
    springBootApplication{
        baseImage.set("openjdk:17-alpine")
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
    jacocoTestReport{
        reports{
            html.required = true
        }
    }
}
