package suwon.jeongja.welfare.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import suwon.jeongja.welfare.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DailyRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String mood;
    private String detail;

    private LocalDate date;

    public DailyRecord(Long userId, String mood, String detail, LocalDate date) {
        this.userId = userId;
        this.mood = mood;
        this.detail = detail;
        this.date = date;
    }

    public void update(String mood, String detail){
        this.mood = mood;
        this.detail = detail;
    }
}
