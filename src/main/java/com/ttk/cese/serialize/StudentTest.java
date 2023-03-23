package com.ttk.cese.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentTest {

    public static void main(String[] args) {

        try {
            serialize();
            deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 序列化
     *
     * @throws IOException
     */
    public static void serialize() throws IOException {

        Student student = new Student();
        student.setName("CodeSheep");
        student.setAge(18);
        student.setScore(1000);

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
        System.out.println();
    }

    /**
     * 反序列化
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(new File("student.txt")));
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(student);
    }

}
