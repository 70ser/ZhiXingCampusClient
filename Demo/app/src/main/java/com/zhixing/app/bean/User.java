package com.zhixing.app.bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZC
 * @since 2023-01-25
 */
@Getter
@Setter
  //(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      //Property("用户id,递增主键")
      private Integer id;

      //Property("用户名，允许重复")
      private String username;

      //Property("用户密码，最好使用md5加密")
      private String password;

      //Property("头像url可以为空,为空默认头像")
      private String avatarUrl;

      //Property("性别，默认为保密")
      private String sex;

      //Property("手机号，可以为空")
      private String phone;

}
