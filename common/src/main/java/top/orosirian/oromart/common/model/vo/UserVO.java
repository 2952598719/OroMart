package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;
import top.orosirian.oromart.common.model.entity.User;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
public class UserVO {

    private String username;

    private Integer type;

    private LocalDateTime createdTime;

    public static UserVO of(User user) {
        return UserVO.builder()
                .username(user.getUsername())
                .type(user.getType())
                .createdTime(LocalDateTime.ofInstant(user.getCreatedTime(), ZoneId.systemDefault()))
                .build();
    }

}
