package com.ttk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // 在使用mybatisplus自带的删除更新方法时，是通过id来进行的，如果主键id不叫id的话，需要加上这个注解，来标识uid是主键id
    @TableId(type = IdType.AUTO)
    private Long uid;

    private String loginName;

    private String userName;

    private String passWord;

    private String sex;

    private Integer age;
}
