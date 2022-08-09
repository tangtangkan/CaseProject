package com.ttk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String content;

    private Long createId;

    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss",timezone="Asia/Shanghai")
    private Date createDate;

    private Long updateId;

    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss",timezone="Asia/Shanghai")
    private Date updateDate;

    @TableField(exist = false)
    private String createName;
}
