package com.isms.ismsbackend;

import com.isms.ismsbackend.dao.UserDao;
import com.isms.ismsbackend.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IsmsBackendApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user);
    }

}
