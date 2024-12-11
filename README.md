> ## 설정 파일 추가
### * 경로 : src/main/resource/application.properties
```
// application.properties

spring.application.name=restapi

#datasources
spring.datasource.driver-class-name=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

#jpa
spring.jpa.open-in-view=false

#hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

#logging.level.org.hibernate.type.descriptor.sql=trace
```

