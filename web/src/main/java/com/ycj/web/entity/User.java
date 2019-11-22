package com.ycj.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/15
 * @time: 9:13
 * @fuction: about the role of class.
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Entity
@Data
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username", nullable = true, length = 32)
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", nullable = true, length = 32)
    private String password;

    /**
     * 年龄
     */
    @Column(name = "age", nullable = true, length = 11)
    private Integer age;

    /**
     * 性别 1=男 2=女 其他=保密
     */
    @Column(name = "sex", nullable = true, length = 11)
    private Integer sex;


//    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "userId", nullable = true, length = 11)
    private String userId;

    @Column(name = "nickname", unique = true, nullable = false, length = 64)
    private String nickname;

    @Column(name = "sign", nullable = false, length = 64)
    private String sign;

    @Column(name = "email", length = 64)
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
