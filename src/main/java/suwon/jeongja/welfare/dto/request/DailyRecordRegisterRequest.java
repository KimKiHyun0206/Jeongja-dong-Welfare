package suwon.jeongja.welfare.dto.request;

import lombok.Data;


@Data
public class DailyRecordRegisterRequest {
    private final Long userId;
    private final String mood;
    private final String detail;
}
