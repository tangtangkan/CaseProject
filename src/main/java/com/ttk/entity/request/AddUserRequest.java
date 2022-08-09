package com.ttk.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    private Long uid;

    private String loginName;

    private String passWord;

    private String userName;

    private String sex;

    private Integer age;

}
