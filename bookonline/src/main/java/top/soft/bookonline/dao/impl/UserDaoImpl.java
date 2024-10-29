package top.soft.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.JdbcUtil;
import top.soft.bookonline.util.Md5Util;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO  t_user (account,password,nickname,avatar,address) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar(),user.getAddress());
    }

    @Override
    public User findUser(User userDto) {
        try {
            String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                    (User.class), userDto.getAccount(), userDto.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean isUserExists(String account) {
        try {
//            定义了一个SQL语句，该语句从t_user表中选择与提供的account匹配的所有行的数量
            String sql = "SELECT COUNT(*) FROM t_user WHERE account = ?";
//       使用JdbcTemplate来执行上述定义的SQL语句。
//        queryForObject方法用来执行查询并期望得到单个结果对象。结果应转换成Integer类型
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class, account);
// 如果count不为空且大于零，则表明存在至少一条与指定account相匹配的记录，因此返回true表示用户存在；否则返回false
            return count != null && count > 0;
        } catch (Exception e) {
            // 打印出异常消息
            System.err.println("Error checking if user exists: " + e.getMessage());
            return false;
        }
    }
}
