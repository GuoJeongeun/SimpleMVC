package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM user WHERE LOWER(username)=LOWER(?) AND password=?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?, ?, NULL, NULL)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        template.update(sql, id);
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户对象
     */
    @Override
    public User find(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 修改用户
     *
     * @param user 用户对象
     */
    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name=?, gender=?, age=?, address=?, qq=?, email=? WHERE id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    /**
     * 查询总记录数
     *
     * @param condition 查询条件
     * @return 总记录数
     */
    @Override
    public Integer findTotalCount(Map<String, String[]> condition) {
        String sql = "SELECT COUNT(*) FROM user WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();

        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" AND ").append(key).append(" LIKE ?");
                params.add("%" + value + "%");
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    /**
     * 分页查询每页记录
     *
     * @param start     开始索引
     * @param rows      每页记录数
     * @param condition 查询条件
     * @return 用户列表
     */
    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" AND ").append(key).append(" LIKE ?");
                params.add("%" + value + "%");
            }
        }
        sb.append(" LIMIT ?, ?");
        params.add(start);
        params.add(rows);
        try {
            return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
        } catch (Exception e) {
            return null;
        }
    }
}
