package com.sky.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    //员工id
    @TableId(value = "id")
    private Long id;

    //员工用户名
    @TableField("username")
    private String username;

    //员工姓名
    @TableField("name")
    private String name;

    //员工密码
    @TableField("password")
    private String password;

    //员工手机号
    @TableField("phone")
    private String phone;

    //员工性别
    @TableField("sex")
    private String sex;

    //身份证号
    @TableField("id_number")
    private String idNumber;

    //员工状态 0-禁用 1-启用
    @TableField("status")
    private Integer status;

    //创建时间
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //更新时间
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //创建人
    @TableField("create_user")
    private Long createUser;

    //更新人
    @TableField("update_user")
    private Long updateUser;


}
