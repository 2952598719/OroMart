package top.orosirian.oromart.api.utils;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.orosirian.oromart.api.client.UserFeignClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserFeignClient client;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    // 返回loginId对应的角色标识（和权限标识符分开，admin也可以只具有部分权限）
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        int type = client.getUserType(Long.parseLong((String)loginId));
        if (type == 0) {
            list.add("admin");
        } else if (type == 1) {
            list.add("user");
        }
        return list;
    }

}
