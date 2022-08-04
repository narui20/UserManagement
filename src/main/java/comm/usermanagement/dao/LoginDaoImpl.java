package comm.usermanagement.dao;

import comm.usermanagement.bean.User;
import comm.usermanagement.entity.UserEntity;
import comm.usermanagement.exceptions.IncorrectCredentialsException;
import comm.usermanagement.utility.PojoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class LoginDaoImpl {

    @Autowired
    @Lazy
    LoginDao loginDao;

    public User loginUser(String email, String password) {
        UserEntity userEntity = loginDao.getUser(email, password);
        if (userEntity != null) {
            return PojoConvertor.convertUserEntityToBean(userEntity);
        } else {
            throw new IncorrectCredentialsException("Incorrect email and password");
        }
    }

    public User getUserByUsername(String email) {
        return PojoConvertor.convertUserEntityToBean(loginDao.getUserByUsername(email));
    }

    public User registerUser(User user) {
        if (loginDao.getUserByUsername(user.getEmail()) != null) {
            return null;
        }
        return PojoConvertor.convertUserEntityToBean(loginDao.save(PojoConvertor.convertUserToEntity(user)));
    }

}
