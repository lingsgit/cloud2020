package com;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        //method1();
        Map map = method2();
        System.out.println(map);
    }

    private static Map method2() {
        String s = "dsflxcnvdfawkerkllkhg;af1d4654536*/-sd0";
        Map<Character,Integer> map1 = new HashMap();
        int length = s.length();
        for (int i = 0; i <length ; i++) {
            char aChar = s.charAt(i);
            Integer integer = map1.get(aChar);
            if(integer==null){
                map1.put(aChar,1);
            }else{
                map1.put(aChar,++integer);
            }
        }


        Map<Character,Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Integer integer = map.get(aChar);
            if(integer==null){
                map.put(aChar,1);
            }else{
                map.put(aChar,++integer);
            }
        }


        Map<Character,Integer> map3 = new HashMap();
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int length1 = next.length();
        for (int i = 0; i <length1 ; i++) {
            char c = next.charAt(i);
            if(!map3.containsKey(c)){
                map3.put(c,1);
            }else{
                Integer integer = map3.get(c);
                map3.put(c,++integer);
            }
        }

        return map3;
    }

    private static void method1() {
        Map map = new HashMap<Integer,Integer>();
        Object put = map.put(1, 1);
        System.out.println(put);
        Object put1 = map.put(1, 2);
        map.put(2,2);
        map.put(3,3);
        System.out.println(put1);
        System.out.println(map);
        System.out.println("===================");
        Set set = map.keySet();
        Set set1 = map.entrySet();
        System.out.println(set);
        System.out.println("===================");
        System.out.println(set1);

        map.put(null,null);
    }
}
