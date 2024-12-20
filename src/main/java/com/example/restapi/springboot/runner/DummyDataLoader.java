package com.example.restapi.springboot.runner;

import com.example.restapi.persistence.user.User;
import com.example.restapi.persistence.user.UserRepository;
import com.example.restapi.shared.enums.Gender;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    public void run(String... args) {

        for (int i = 0; i < 75; i ++) {
            Faker faker = new Faker();

            String name = faker.name().fullName();
            String gender = faker.gender().binaryTypes().toUpperCase();
            String hobby = faker.hobby().activity();

            userRepository.insertUser(new User(name, Gender.valueOf(gender), hobby));
        }
    }
}
