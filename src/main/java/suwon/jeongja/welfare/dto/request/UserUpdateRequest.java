package suwon.jeongja.welfare.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private final String name;
    private final Long age;
}
