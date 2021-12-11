package com.zking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @Size(max = 5,min = 3,message = "密码长度必须3-5")
    private String pwd;
    @NotBlank(message = "邮箱地址不能为空")
    @Email(message = "请输入正确的邮箱地址")
    private String email;

}
