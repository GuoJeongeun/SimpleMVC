package com.example.dao;

import com.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    void add(User user);

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    void delete(int id);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户对象
     */
    User find(int id);

    /**
     * 修改用户
     *
     * @param user 用户对象
     */
    void update(User user);

    /**
     * 查询总记录数
     *
     * @param condition 查询条件
     * @return 总记录数
     */
    Integer findTotalCount(Map<String, String[]> condition);


    /**
     * 分页查询每页记录
     *
     * @param start     开始索引
     * @param rows      每页记录数
     * @param condition 查询条件
     * @return 当前页记录
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
