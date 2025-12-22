plugins {
    java
    id("org.springframework.boot") version "4.0.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.phoenixware.Shopify_Integration"
version = "0.0.1-SNAPSHOT"
description = "Shopify_Integration_Backend"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    //for automatic restart when the code is updated
    implementation("org.springframework.boot:spring-boot-devtools")
    //for application health and metrics
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    //adding security... this way we can lock down endpoints.
    implementation("org.springframework.boot:spring-boot-starter-security")
    //adding spring data jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // PostgresSQL driver
    runtimeOnly("org.postgresql:postgresql")

    // Flyway for DB migrations...
    implementation("org.flywaydb:flyway-core")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
