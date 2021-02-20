package com.java.mapper;

import com.java.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectUserName(String userName);

    int updateUserPwd(User user);

    User selectIdCard(String idCard);

    int SignUpUser(User user);

    List<User> selectUser();

    int deleteUser(int id);

    int updateUser(User user);

    User selectAcc(String acc);

    User selectIdNum(String idCard);

    int addUser(User user);

    int updateUserInformation(User user);

    User selectSingleAcc(String acc);
}
