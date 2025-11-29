plugins {
    kotlin("jvm") version "2.3.0-RC"
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }
    wrapper {
        gradleVersion = "9.2.1"
    }
}
