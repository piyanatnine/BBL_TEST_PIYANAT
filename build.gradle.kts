plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Web (สำหรับ @RestController, @RequestMapping ฯลฯ)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Data JPA (สำหรับ @Entity, JpaRepository)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Validation (สำหรับ @NotBlank, @Email)
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // H2 in-memory database (สำหรับทดสอบ ไม่ต้องติดตั้ง DB จริง)
    runtimeOnly("com.h2database:h2")

    // Testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}