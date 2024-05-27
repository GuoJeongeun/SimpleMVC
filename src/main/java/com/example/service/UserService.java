package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 登录成功返回用户对象，否则返回null
     */
    User login(User user);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void deleteUser(int id);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户对象
     */
    User findUserById(int id);

    /**
     * 修改用户
     *
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除选中用户
     *
     * @param ids 用户id数组
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param rows        每页显示的记录数
     * @param condition   查询条件
     * @return 分页对象
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
