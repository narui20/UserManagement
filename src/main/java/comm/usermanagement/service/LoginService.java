package comm.usermanagement.service;

import comm.usermanagement.bean.User;

public interface LoginService {

    User register(User user);

    User loginUser(String email, String password);

    User getUserByUsername(String email);
}
