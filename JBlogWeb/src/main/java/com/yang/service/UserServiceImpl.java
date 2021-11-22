package com.yang.service;

import com.yang.db.UserDAO;
import com.yang.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public List<UserVO> getUserList() {
        return userDAO.userVOList();
    }

    @Override
    public UserVO getUser(String id, String password) {
        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);
        return userDAO.getUser(vo);
    }
}
