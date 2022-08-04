package comm.usermanagement.dao;

import comm.usermanagement.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl {

    @Autowired
    @Lazy
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers()
                .stream()
                .map(userEntity -> {
                    User user = new User();
                    user.setId(userEntity.getId());
                    user.setEmail(userEntity.getEmail());
                    user.setName(userEntity.getName());
                    return user;
                }).collect(Collectors.toList());
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    public Integer updateUser(User user) {
        return userDao.updateUser(user.getName(), user.getId());
    }
}
