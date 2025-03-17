
# RestAPI 서버 예제 프로젝트

> ## 설정 파일 추가

### * 경로 : src/main/resource/application.properties
```
// application.properties

spring.application.name=restapi

#datasources
spring.datasource.driver-class-name="DRIVER" 
spring.datasource.url="DB_URL"
spring.datasource.username="ID"
spring.datasource.password="PASSWORD"

#jpa
spring.jpa.open-in-view=false

#hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

#logging.level.org.hibernate.type.descriptor.sql=trace
```

