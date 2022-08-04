package comm.usermanagement.utility;

import comm.usermanagement.bean.User;
import comm.usermanagement.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class PojoConvertor {

    public static User convertUserEntityToBean(UserEntity entity){
        User bean=new User();
        BeanUtils.copyProperties(entity,bean);
        return bean;
    }

    public static UserEntity convertUserToEntity(User bean){
        UserEntity entity=new UserEntity();
        BeanUtils.copyProperties(bean,entity);
        return entity;
    }
}
