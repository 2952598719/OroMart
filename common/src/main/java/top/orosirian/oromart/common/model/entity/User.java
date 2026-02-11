package top.orosirian.oromart.common.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class User {

    private Long userId;

    private String username;

    private String password;

    private Integer status;

    private Integer type;

    private Instant createTime;

    private Instant updateTime;

}
