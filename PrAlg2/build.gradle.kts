plugins {
    id("java")
}

group = "dev.ua.ikeepcalm"
version = ""

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks.withType<Jar> {
    archiveBaseName.set("pralg2")
    manifest {
        attributes["Main-Class"] = "dev.ua.ikeepcalm.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}