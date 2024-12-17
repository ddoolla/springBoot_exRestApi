package com.axios.restapi.springboot.runner;

import com.axios.restapi.business.UserService;
import com.axios.restapi.persistence.UserRepository;
import com.axios.restapi.persistence.entity.User;
import com.axios.restapi.shared.enums.Gender;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    /**
     *  * dataFaker - 랜덤 날짜 생성 방법 (time 패키지 사용)
     *      ex) 과거 날짜
     *          Instant pastInstant = faker.timeAndDate().past();
     *          LocalDateTime past = LocalDateTime.ofInstant(pastInstant, ZoneId.systemDefault());
     */
    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 75; i ++) {
            Faker faker = new Faker();

            String name = faker.name().fullName();
            String gender = faker.gender().binaryTypes().toUpperCase();
            String hobby = faker.hobby().activity();

            userRepository.insertUser(new User(name, Gender.valueOf(gender), hobby));
        }
    }
}
