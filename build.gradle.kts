plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
//	id("se.solrike.sonarlint") version "1.0.0-beta.15"
//	id("com.github.spotbugs") version "5.0.14"
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
	implementation("org.apache.kafka:kafka-streams")
	implementation("org.springframework.kafka:spring-kafka")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

	// This dependency is used internally, and not exposed to consumers on their own compile classpath.
	implementation("com.google.guava:guava:31.0.1-jre")

/*
	// sonarlint
	implementation("org.sonarsource.sonarlint.core:sonarlint-core:8.0.2.42487")
	"sonarlintPlugins"("org.sonarsource.java:sonar-java-plugin:7.20.0.31692") // versions after this will not work with sonarlint
	"sonarlintPlugins"("org.sonarsource.xml:sonar-xml-plugin:2.6.1.3686")
	"sonarlintPlugins"("org.sonarsource.text:sonar-text-plugin:2.0.1.611")

	// spotbugling
	"spotbugsPlugins"("com.h3xstream.findsecbugs:findsecbugs-plugin:1.12.0")
	"spotbugsPlugins"("com.mebigfatguy.sb-contrib:sb-contrib:7.4.7")
	"spotbugs"("com.github.spotbugs:spotbugs:4.8.0")
*/
}

/*

tasks.register("sonarlintListRules", se.solrike.sonarlint.SonarlintListRules::class.java) {
	description = "List sonarlint rules"
	group = "verification"
}

configure<se.solrike.sonarlint.SonarlintExtension> {
	excludeRules.set(listOf("java:S1186"))
	includeRules.set(listOf("java:S1176", "java:S1696", "java:S4266"))
	ignoreFailures.set(false)
	maxIssues.set(0) // default 0
	reportsDir // default build/reports/sonarlint
	// note that rule parameter names are case sensitive
	ruleParameters.set(mapOf(
			"java:S1176" to mapOf(
					"forClasses" to "**.api.**",      // need javadoc for public methods in package matching 'api'
					"exclusion" to "**.private.**"    // do not need javadoc for classes under 'private'. Default is **.internal.**
			)
	))
	showIssues.set(true) // default true
}

tasks.sonarlintMain {
	dependsOn(":copyHTML")
	isEnabled
}

tasks.named("spotbugsMain", SpotBugsTask::class.java) {
	isEnabled
//	effort.set(Effort.LESS)
//	excludeFilter.set(file("./plugin-config/spotbugs/exclude.xml"))
//	ignoreFailures = true
//	showStackTraces = false
}

tasks.named("spotbugsTest", SpotBugsTask::class.java) {
	isEnabled = false
}

*/

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
