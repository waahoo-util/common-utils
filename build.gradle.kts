plugins {
  `maven-publish`
  kotlin("jvm") version "1.3.71"
}

group = "com.github.waahoo"
version = "0.0.2"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  implementation("com.sun.mail:javax.mail:1.6.2")
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}

val kotlinSourcesJar by tasks

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["kotlin"])
      artifact(kotlinSourcesJar)
    }
  }
}