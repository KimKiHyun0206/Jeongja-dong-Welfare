package suwon.jeongja.welfare.dto.response;

import lombok.Data;
import suwon.jeongja.welfare.entity.User;

@Data
public class UserResponse {
    private final Long id;
    private final String name;
    private final Long age;
    private final String gender;

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getGender()
        );
    }
}
