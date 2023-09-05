package com.ttk.examplecase.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private String name;

    private Integer age;

    private Integer score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {

        // 调用默认的反序列化函数
        objectInputStream.defaultReadObject();

        // 手工检查反序列化后学生成绩的有效性，若发现有问题，即终止操作！
        if (0 > score || 100 < score) {
            throw new IllegalArgumentException("学生分数只能在0到100之间！");
        }
    }
}