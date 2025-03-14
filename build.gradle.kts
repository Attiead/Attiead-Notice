plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
}

group = "in.attiead"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }
//extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

	// This dependency is used internally, and not exposed to consumers on their own compile classpath.
	implementation("com.google.guava:guava:31.0.1-jre")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	outputs.dir(snippetsDir)
}

tasks.asciidoctor {
	inputs.dir(snippetsDir)
	dependsOn(tasks.test)
	doFirst {
		delete {
			file("src/main/resources/static/docs")
		}
	}
}

val copyDocument by tasks.register<Copy>("copyDocument") { // (12)
	dependsOn(tasks.asciidoctor)
	from("build/docs/asciidoc")
	into("src/main/resources/static/docs")
}

tasks.register("copyHTML", Copy::class) {
	dependsOn(tasks.asciidoctor)
	from(file("build/asciidoc/html5"))
	into(file("src/main/resources/static/docs"))
}

tasks.build {
	dependsOn(tasks.getByName("copyHTML"))
}

tasks.bootJar {
	dependsOn(tasks.asciidoctor)
	dependsOn(tasks.getByName("copyHTML"))
}
