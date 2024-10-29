    package top.soft.bookonline.service.impl;

    import jakarta.servlet.annotation.WebServlet;
    import top.soft.bookonline.dao.UserDao;
    import top.soft.bookonline.dao.impl.UserDaoImpl;
    import top.soft.bookonline.entity.User;
    import top.soft.bookonline.service.RegisterService;
    import top.soft.bookonline.service.UserService;
    import top.soft.bookonline.service.impl.UserServiceImpl;
//实现接口
    public class RegisterServiceImpl implements RegisterService {
//        使用一个 UserDao 实例来处理与用户相关的数据库操作
        private final UserDao userDao = new UserDaoImpl();
        @Override
//        这段代码定义了一个用户注册的方法signRegister，它负责检查提供的账号是否已存在，如果不存在，则创建一个新的用户记录并将其保存到数据库中。
        public User signRegister(String account, String password, String nickname,String address) {
            if (userDao.isUserExists(account)) {
                return null; // 账号已存在，返回 null
            }
            User user = User.builder().account(account).password(password).nickname(nickname).address(address).avatar("https://wx2.sinaimg.cn/mw690/006aCKOzgy1htvumy63cej31400u0n4o.jpg").build();
//            调用userDao的insertUser方法尝试将新建的User对象插入到数据库中
            int result = userDao.insertUser(user);
//            处理result的结果
            if (result >0) {
                return user;
            }else{
                return null;
            }
        }
    }