package comm.usermanagement.dao;

import comm.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RepositoryDefinition(idClass = Integer.class, domainClass = UserEntity.class)
public interface UserDao {

    @Query("Select k from UserEntity k")
    List<UserEntity> getUsers();

    @Modifying
    @Query("Delete from UserEntity k where id = ?1")
    int deleteUser(int id);

    @Modifying
    @Query("Update UserEntity k set name =?1 where id = ?2")
    int updateUser(String name, int id);
}

