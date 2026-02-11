package top.orosirian.oromart.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    ADMIN(0),
    USER(1);

    private final Integer code;

}
