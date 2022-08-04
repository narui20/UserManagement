package comm.usermanagement.dao;

import comm.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import javax.transaction.Transactional;

@Transactional
@RepositoryDefinition(idClass = Integer.class, domainClass = UserEntity.class)
public interface LoginDao {

    UserEntity save(UserEntity entity);

    @Query("Select k from UserEntity k where k.email = ?1 and k.password = ?2")
    UserEntity getUser(String email, String password);

    @Query("Select k from UserEntity k where k.email = ?1")
    UserEntity getUserByUsername(String email);

}
