plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
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

    // 가짜데이터 생성 라이브러리
    implementation("net.datafaker:datafaker:2.4.2")
}

/*
	implementation - 컴파일, 런타임에 모두 필요한 종속성
	compileOnly - 컴파일에만 필요한 종속성
	runtimeOnly - 런타임에만 필요한 종속성
	testImplementation - 테스트 컴파일하고 실행하는데 필요한 종속성
	testRuntimeOnly - 테스트 실행에만 필요한 종속성

	annotationProcessor
	 	- 컴파일 시점에 어노테이션을 분석하고, 특정 작업을 수행하는 도구 (모든 어노테이션이 annotationProcessor 가 필요한 것은 아니다.)
	 	- 롬복같은 경우 컴파일 후 class 파일을 보면 해당 클래스에 어노테이션에 해당하는 코드가 생성된 것을 확인할 수 있다.
	 	-> 컴파일 시점에 롬복 어노테이션을 분석하여 코드를 생성하는 작업이 이루어졌다.

	 	만약, 런타임 시점에 메소드가 호출될 때, 어노테이션에 대한 코드 생성이 이루어진다면 annotationProcessor 는 필요하지 않다. (리플랙션 사용)

	 	ex) @Hello 사용자 정의 어노테이션을 생성하고 컴파일 시점에 System.out.println("Hello!"); 를 메소드 블록 시작부분에 생성한다고
	 		가정했을 경우, AbstractProcessor 를 상속받아 process 메서드를 구현해야 컴파일 시점에 어노테이션 프로세서가 호출되어 해당 어노테이션을 실행할 수 있다.
*/

tasks.withType<Test> {
    useJUnitPlatform()
}


