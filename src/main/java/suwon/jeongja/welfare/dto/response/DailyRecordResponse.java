package suwon.jeongja.welfare.dto.response;

import lombok.Data;
import suwon.jeongja.welfare.entity.DailyRecord;

import java.time.LocalDate;

@Data
public class DailyRecordResponse {
    private final Long id;
    private final Long userId;
    private final String mood;
    private final String detail;
    private final LocalDate date;

    public static DailyRecordResponse from(DailyRecord dailyRecord){
        return new DailyRecordResponse(
                dailyRecord.getId(),
                dailyRecord.getUserId(),
                dailyRecord.getDetail(),
                dailyRecord.getDetail(),
                dailyRecord.getDate()
        );
    }
}
