plugins {
	java
	id("java-library")
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	id ("de.schablinski.activejdbc-gradle-plugin") version "2.0.1"
}

group = "com.pomni"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.google.guava:guava:22.0")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("junit:junit:4.13.1")
	implementation("org.javalite:activejdbc:2.3")
	implementation("org.mariadb.jdbc:mariadb-java-client:2.1.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
