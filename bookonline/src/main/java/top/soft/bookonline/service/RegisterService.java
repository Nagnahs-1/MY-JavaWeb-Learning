package top.soft.bookonline.service;

import top.soft.bookonline.entity.User;

public interface RegisterService {
//    该接口包含一个名为 signRegister 的方法这个方法接收四个字符串参数
    User signRegister(String account, String password, String nickname,String address);
}