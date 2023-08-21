tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":monitoring"))
    implementation(project(":logging"))
    implementation(project(":storage"))
    testImplementation(project(":restdocs"))

    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
}
