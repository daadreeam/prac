package com.lsw.ds.tree.bi;

import lombok.Data;

/**
 * 二叉树节点
 */
@Data
public class BiNode {
    private Integer val;    //节点数据
    private BiNode leftChild; //左子节点的引用
    private BiNode rightChild; //右子节点的引用
    //打印节点内容
    public void display(){
        System.out.println(val);
    }
}
