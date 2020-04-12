package com.lsw.prac.mysourcecode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;

public class MySourceCode {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Iterator<Integer> iterator = integers.iterator();


        System.out.println("hha");

    }
}

@Data
@AllArgsConstructor
class Person{
    private String name;
    private int age;
}
