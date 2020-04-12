//package com.lsw.prac.test1;
//
//import cn.hutool.core.date.DateUtil;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.BeanUtils;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class BeanCopyTest {
//    public static void main(String[] args) {
//        BeanA beanA = new BeanA("a", 11, 1);
//        BeanB beanB = new BeanB("b", 12, 3);
//        BeanC beanC = new BeanC("c", 500, "c", 600, 0);
//        BeanUtils.copyProperties(beanA, beanC);
//        BeanUtils.copyProperties(beanB, beanC);
//        System.out.println("beanC = " + beanC);
//
//        BeanA beanA2 = new BeanA("a2", 112, 12);
//        BeanB beanB2 = new BeanB("b2", 122, 32);
//        BeanUtils.copyProperties(beanA2, beanC);
//        BeanUtils.copyProperties(beanB2, beanC);
//        System.out.println("beanC = " + beanC);
//
//        List<BeanA> list = Arrays.asList(beanA, beanA2);
//        List<BeanC> cList = new ArrayList<>();
//        BeanC c = new BeanC();
//        for (BeanA bean : list) {
//            c.setAgeA(bean.getAgeA());
//            c.setNameA(bean.getNameA());
//            cList.add(c);
//        }
//        System.out.println("c = " + c);
//        System.out.println("cList = " + cList);
//
//        System.out.println("DateUtil.date() = " + DateUtil.date());
//    }
//}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class BeanA {
//    private String nameA;
//    private Integer ageA;
//    private Integer exctraA;
//}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class BeanB {
//    private String nameB;
//    private Integer ageB;
//    private Integer exctraB;
//}
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class BeanC {
//    private String nameA;
//    private Integer ageA;
//    private String nameB;
//    private Integer ageB;
//    private Integer exctraC;
//
//}
