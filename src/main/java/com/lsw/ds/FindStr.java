package com.lsw.ds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class FindStr {
    public static void main(String[] args) {

    }

    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Map<String,String>> map = new HashMap<>();
        // 将当前字符串可能转换的字符串map加入map当中
        for (String s : wordList) {
            Map<String, String> sLabMap = getLab(wordList, s);
            map.put(s, sLabMap);
        }
        // 得到开始字符串可以转换的字符串map
        Map<String, String> beginMap = getLab(wordList, beginWord);

        // 从当前开始节点开始对可以转换的节点进行转换
        beginMap.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                String key = s;
                while (map.containsKey(key)) {
                    // 临接节点map
                    Map<String, String> stringStringMap = map.get(key);
                    if (stringStringMap.containsKey(endWord)) {
                        // 说明找到了
                        break;
                    } else {
                        // 循环尝试其他节点 for
                    }
                }
            }
        });
        return null;
    }

    /**
     *
     * @param wordList
     * @param word
     * @return 返回的是word所能转换的字符的map，key为字符串名
     */
    public static Map<String, String> getLab(List<String> wordList, String word){
        // todo
        return null;
    }
}
