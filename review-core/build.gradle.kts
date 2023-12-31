tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":review-monitoring"))
    implementation(project(":review-logging"))
    implementation(project(":review-storage"))
    implementation(project(":review-client"))
    testImplementation(project(":review-docs"))

    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-aop")
}
