package com.lsw.ds;

import java.util.HashMap;

public class HashTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put(null, null);


        String k1 = map.get("k1");
        String k2 = map.get("k2");
    }
}
