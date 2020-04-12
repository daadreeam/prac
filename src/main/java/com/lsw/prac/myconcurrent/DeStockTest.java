package com.lsw.prac.myconcurrent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeStockTest {
    private static int stock = 5;

    private MyLock myLock = new MyLock();
//    public static void main(String[] args) {
//
//        Unsafe unsafe = Unsafe.getUnsafe();
//
//
//    }


    @GetMapping("/order")
    public void deStock(){
//        System.out.println("这是order接口");

        // todo 取锁
        myLock.lock();

        // 1.取库存 getStock
        if (stock <= 0) {
            System.out.println("下单失败，当前库存为0");
            myLock.unlock();
            return;
        }

        // 2.减库存
        stock--;
        System.out.println("下单成功，当前库存为 " + stock);

        // 3.存库存

        // todo 释放锁
        myLock.unlock();

        return;
    }

    @GetMapping("/stock/{num}")
    public void sets(@PathVariable(value = "num") String num){
        stock = Integer.valueOf(num);
    }
}
