plugins {
    java
    id("org.springframework.boot") version "4.0.0"
    id("io.spring.dependency-management") version "1.1.7"
}
val springCloudVersion by extra("2025.1.0")

group = "com.phoenixware.InventoryNexus"
version = "0.1.1"
description = "InventoryNexus"

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
    //implementation("org.springframework.boot:spring-boot-starter-security")
    //adding spring data jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.projectlombok:lombok")
//    implementation("org.springframework.boot:spring-boot-starter-security-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-security-oauth2-resource-server")
//    implementation("org.springframework.cloud:spring-cloud-starter-vault-config")


    // PostgresSQL driver
    runtimeOnly("org.postgresql:postgresql")
    compileOnly("org.projectlombok:lombok")

    // Flyway for DB migrations...
    implementation("org.flywaydb:flyway-core")
    val mapstructVersion = "1.6.3"
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")

    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf(
        "-Amapstruct.defaultComponentModel=spring"
    ))
}

tasks.withType<Test> {
    useJUnitPlatform()
}