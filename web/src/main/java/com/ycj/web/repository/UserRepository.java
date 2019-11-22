package com.ycj.web.repository;

import com.ycj.web.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/15
 * @time: 9:16
 * @fuction: about the role of class.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    List<User> findUsersByUsernameIsContaining(String username);

    @Query("select u from User u where u.username like %?1%")
    List<User> getByUsernameLike(String username);

    @Query("select u from User u where u.username = :username or u.email = :email")
    User getByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

    @Query(value = "select * from tb_user u where u.email = ?1", nativeQuery = true)
    User queryUserByEmailOne(String email);

    @Query(value = "select * from tb_user u where u.email = :email", nativeQuery = true)
    User queryUserByEmailTwo(@Param("email") String email);

    /**
     * 关于动态分页和排序的使用
     * new PageRequest(0, 5);
     * new PageRequest(0, 5, Sort.Direction.ASC, "username");
     * new PageRequest(0, 5, new Sort(Sort.Direction.ASC, "username"));
     *
     * PageRequest.of(0, 5);
     * PageRequest.of(0, 5, Sort.Direction.ASC, "username");
     * PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "username"));
     */

    @Query(value = "select * from tb_user u where u.username like %?1%",
            countQuery = "select count(1) from tb_user u where u.username = %?1%",
            nativeQuery = true)
    Page<User> queryByUsernameLike(String username, Pageable pageable);

    @Query("select u from User u where u.username like %?1%")
    Page<User> findByUsernameLike(String username, Pageable pageable);

    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameAndSort(String username, Sort sort);


    //单独使用@Query注解只是查询，如涉及到修改、删除则需要再加上@Modifying注解
    @Transactional()
    @Modifying
    @Query("update User u set u.password = ?2 where u.username = ?1")
    int updatePasswordByUsername(String username, String password);

    @Transactional()
    @Modifying
    @Query("delete from User where username = ?1")
    void deleteByUsername(String username);

}
