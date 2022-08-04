package comm.usermanagement.service;

import comm.usermanagement.bean.User;
import comm.usermanagement.dao.LoginDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDaoImpl loginDao;

    @Override
    public User register(User user) {
        return loginDao.registerUser(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return loginDao.loginUser(email, password);
    }

    @Override
    public User getUserByUsername(String email) {
        return loginDao.getUserByUsername(email);
    }

}
