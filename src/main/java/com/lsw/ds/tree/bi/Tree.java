//package com.lsw.ds.tree.bi;
//
//import lombok.Data;
//
//@Data
//public class Tree {
//
////    BiNode root;
//
//    public BiNode insert(int key) {
//        return null;
//    }
//    public Boolean delete(int key){
//        return null;
//    }
//    public Boolean find(int key, BiNode biNode){
//        if (biNode == null) {
//            return false;
//        } else {
//            if (key > biNode.getVal()) {
//                // key大于根节点 遍历右子树
//                return find(key, biNode.getRightChild());
//            } else if (key < biNode.getVal()) {
//                // key小于根节点 遍历左子树
//                return find(key, biNode.getLeftChild());
//            } else {
//                // 相等
//                return true;
//            }
//        }
//    }
//}
