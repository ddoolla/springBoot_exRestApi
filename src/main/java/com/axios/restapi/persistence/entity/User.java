package com.axios.restapi.persistence.entity;

import com.axios.restapi.shared.enums.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String hobby;

    public User(String name,
                Gender gender,
                String hobby) {
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
    }
}
