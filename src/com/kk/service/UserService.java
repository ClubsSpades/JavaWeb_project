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

    // ��¼����
    public User login(String username, String password) throws UserException {
        if (username == null || username.trim().isEmpty()) {
            throw new UserException("�������û�����");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new UserException("���������룡");
        }

        try (SqlSession session = factory.openSession()) {
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.findByUsername(username);
            if (user == null) {
                throw new UserException("���û��������ڣ�");
            }
            if (!user.getPassword().equals(password)) {
                throw new UserException("�������");
            }
            return user;
        }
    }

    // ע�᷽��
    public void register(User user) throws UserException {
        if (user == null) {
            throw new UserException("�û���Ϣ����Ϊ�գ�");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new UserException("�������û�����");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new UserException("���������룡");
        }

        try (SqlSession session = factory.openSession(true)) { // �Զ��ύ����
            UserDao userDao = session.getMapper(UserDao.class);

            User existingUser = userDao.findByUsername(user.getUsername());
            if (existingUser != null) {
                throw new UserException("�û����Ѵ��ڣ�");
            }

            int result = userDao.addUser(user);
            if (result != 1) {
                throw new UserException("ע��ʧ�ܣ������ԣ�");
            }
        }
    }
}
