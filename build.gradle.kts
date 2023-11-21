plugins {
	kotlin("jvm") version "1.9.20"
	application
	`maven-publish`
}

group = "za.co.zone"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

group = "za.co.zone"
version = "1.0"

tasks.test {
	useJUnitPlatform()
}
dependencies {

	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
	implementation("com.google.code.gson:gson:2.10.1")

	testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")

}

tasks.test {
	useJUnitPlatform()
}

kotlin {
	jvmToolchain(jdkVersion = 17)
}

application {
	mainClass.set("MainKt")
}

publishing {
	publications {
		create<MavenPublication>(name = "release") {
			groupId = "com.github.Morons"
			artifactId = "kotlin-library"
			version = "1.0.4"

			from(components["java"])
		}
	}
}