package comm.usermanagement.service;

import comm.usermanagement.bean.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    int deleteUser(int id);

    Integer updateUser(User user);
}
