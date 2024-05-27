package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.PageBean;
import com.example.pojo.User;
import com.example.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 登录成功返回用户对象，否则返回null
     */
    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户对象
     */
    @Override
    public User findUserById(int id) {
        return userDao.find(id);
    }

    /**
     * 修改用户
     *
     * @param user 用户对象
     */
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    /**
     * 删除选中用户
     *
     * @param ids 用户id数组
     */
    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null) {
            for (String id : ids) {
                userDao.delete(Integer.parseInt(id));
            }
        }
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param rows        每页显示的记录数
     * @param condition   查询条件
     * @return 分页对象
     */
    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int _currentPage = Integer.parseInt(currentPage);
        int _rows = Integer.parseInt(rows);

        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(_currentPage);
        pb.setRows(_rows);

        // 总记录数
        int totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 起始索引
        int start = (_currentPage - 1) * _rows;
        List<User> list = userDao.findByPage(start, _rows, condition);
        pb.setList(list);
        // 总页数
        int totalPage = totalCount % _rows == 0 ? totalCount / _rows : totalCount / _rows + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
