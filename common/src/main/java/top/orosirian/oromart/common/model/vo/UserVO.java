package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserVO {

    private String username;

    private LocalDateTime createTime;

}
