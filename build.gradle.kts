plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.axios"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    /**
     * ※ QueryDsl
     * 		- Java EE (javax) -> Jakarta EE 로 변경됨 (스프링 3.0 이후 부터는 jakarta 표준을 따름)
     * 		  (Oracle 에서 Eclipse 제단으로 넘어가면서 이름과 패키지명 변경)
     *
     * 	 	- javax.persistence 가 기존 표준이어서 그런지 jakarta.persistence 패키지를 사용하는데도
     * 	 	  분류자로 jakarta 를 명시적으로 붙여주지 않으면 동작하지 않는다.
     */
    /* querydsl */
    // map 표기법
    implementation(group = "com.querydsl", name = "querydsl-jpa", version = "5.0.0", classifier = "jakarta")

    // 문자열 표기법
    implementation("com.querydsl:querydsl-sql:5.0.0")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")

    // annotationProcessor - 컴파일 시점에 어노테이션 처리
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


