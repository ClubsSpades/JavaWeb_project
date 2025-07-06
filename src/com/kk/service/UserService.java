package com.kk.service;

import com.kk.dao.UserDao;
import com.kk.entity.User;
import com.kk.exception.UserException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private final SqlSessionFactory factory;

    public UserService(SqlSessionFactory factory) {
        this.factory = factory;
    }

    // 登录方法
    public User login(String username, String password) throws UserException {
        if (username == null || username.trim().isEmpty()) {
            throw new UserException("请输入用户名！");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new UserException("请输入密码！");
        }

        try (SqlSession session = factory.openSession()) {
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.findByUsername(username);
            if (user == null) {
                throw new UserException("该用户名不存在！");
            }
            if (!user.getPassword().equals(password)) {
                throw new UserException("密码错误！");
            }
            return user;
        }
    }

    // 注册方法
    public void register(User user) throws UserException {
        if (user == null) {
            throw new UserException("用户信息不能为空！");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new UserException("请输入用户名！");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new UserException("请输入密码！");
        }

        try (SqlSession session = factory.openSession(true)) { // 自动提交事务
            UserDao userDao = session.getMapper(UserDao.class);

            User existingUser = userDao.findByUsername(user.getUsername());
            if (existingUser != null) {
                throw new UserException("用户名已存在！");
            }

            int result = userDao.addUser(user);
            if (result != 1) {
                throw new UserException("注册失败，请重试！");
            }
        }
    }
}
