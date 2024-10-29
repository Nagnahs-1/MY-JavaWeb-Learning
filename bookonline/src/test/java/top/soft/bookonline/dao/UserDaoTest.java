package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().nickname("333").password("123456")
                .address("江苏南京").avatar("").account("333").build();
        userDao.insertUser(user);
    }

    @Test
    void findUser() {
    }
}