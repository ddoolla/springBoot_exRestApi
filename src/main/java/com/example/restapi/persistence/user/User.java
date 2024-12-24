package com.example.restapi.persistence.user;

import com.example.restapi.persistence.common.BaseEntity;
import com.example.restapi.shared.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private String nickName;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String hobby;

    public User(String nickName,
                String password,
                String name,
                Gender gender,
                String hobby) {
        this.nickName = nickName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
    }

    /**
     * Post 생성 시 User 연관관계 매핑 필드에 Id 값에 해당하는 임시 엔터티를 전달 목적으로 만듬
     * 주의할 점은 save() 된 후 생성된 엔터티를 반환하는데, User 정보는 id 를 제외하고는 모두 null (실제 데이터 불일치)
     * 이 프로젝트에서는 반환된 엔터티를 직접적으로 사용하지는 않지만 조금 찝찝한 부분이 있다.
     */
    public static User toTemp(Long id) {
        User user = new User();
        user.id = id;
        return user;
    }
}
