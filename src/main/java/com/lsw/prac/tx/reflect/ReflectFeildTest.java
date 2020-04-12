package com.lsw.prac.tx.reflect;

import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectFeildTest {
        public static void main(String[] args) throws Exception {
            Class stdClass = Student.class;
            Student student = new Student();
            student.setName("lsw");
            student.setScore(100);
            student.setGrade(9);
            // 获取public字段"score":
            System.out.println(stdClass.getField("score"));
            // 获取继承的public字段"name":
            System.out.println(stdClass.getField("name"));
            // 获取private字段"grade":
            Field grade = stdClass.getDeclaredField("grade");
            grade.setAccessible(true);
            grade.set(student, 10);
            Object o = grade.get(student);
            System.out.println(o);
            System.out.println(grade);

            System.out.println("=========================");

            // 获取public方法getScore，参数为String:
            System.out.println(stdClass.getMethod("getScore"));
            // 获取继承的public方法getName，无参数:
            System.out.println(stdClass.getMethod("getName"));
            // 获取private方法getGrade，参数为int:
            System.out.println(stdClass.getDeclaredMethod("getGrade"));

            Method setName = stdClass.getMethod("setName", String.class);
            System.out.println("student = " + student);
            setName.invoke(student,"invoke哈哈哈");
            System.out.println("student = " + student);

            Method getNamePrivate = stdClass.getDeclaredMethod("getNamePrivate");
            getNamePrivate.setAccessible(true);
            System.out.println("getNamePrivate.invoke(student) = " + getNamePrivate.invoke(student));
        }
}
class Student extends Person {
    public int score;
    private int grade;

    private String getNamePrivate(){
        return this.name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

@Data
@ToString
class Person {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
