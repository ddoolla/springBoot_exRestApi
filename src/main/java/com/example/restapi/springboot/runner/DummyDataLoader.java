package com.example.restapi.springboot.runner;

import com.example.restapi.persistence.post.Post;
import com.example.restapi.persistence.post.PostRepository;
import com.example.restapi.persistence.user.User;
import com.example.restapi.persistence.user.UserRepository;
import com.example.restapi.shared.enums.Gender;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import net.datafaker.providers.base.Text;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static net.datafaker.providers.base.Text.DIGITS;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    /**
     * * dataFaker - 랜덤 날짜 생성 방법 (time 패키지 사용)
     * ex) 과거 날짜
     * Instant pastInstant = faker.timeAndDate().past();
     * LocalDateTime past = LocalDateTime.ofInstant(pastInstant, ZoneId.systemDefault());
     */
    @Override
    public void run(String... args) {

        /* user 더미 데이터 */
        for (int i = 0; i < 75; i++) {
            Faker faker = new Faker();

            String color = faker.color().name();
            String animal = faker.animal().name();
            int number = faker.number().numberBetween(1, 100);

            String nickName = color + "_" + animal + number;
            String password = faker.text().text(Text.TextSymbolsBuilder.builder()
                    .len(8)
                    .with(DIGITS).build());
            String name = faker.name().fullName();
            String gender = faker.gender().binaryTypes().toUpperCase();
            String hobby = faker.hobby().activity();

            userRepository.insertUser(new User(
                            nickName,
                            password,
                            name,
                            Gender.valueOf(gender),
                            hobby
                    )
            );
        }

        /* post 더미 데이터 */
        for (int i = 0; i < 75; i++) {
            Faker faker = new Faker();

            String title = faker.book().title();
            String genre = faker.book().genre();
            String author = faker.book().author();
            String publisher = faker.book().publisher();
            String content = genre + ", " + author + ", " + publisher;
            long userId = faker.number().numberBetween(1, 75);

            postRepository.insertPost(new Post(title, content, User.toTemp(userId)));
        }
    }
}
