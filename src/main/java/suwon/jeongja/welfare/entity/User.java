package suwon.jeongja.welfare.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import suwon.jeongja.welfare.common.BaseEntity;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Long age;

    public User(String name, String gender, Long age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void update(String title, String gender, Long age) {
        this.name = title;
        this.gender = gender;
        this.age = age;
    }
}