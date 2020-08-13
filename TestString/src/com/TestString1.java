package com;

public class TestString1 {
    /*
    * [word1#word2#word3#]
    * */

    public static void main(String[] args) {
       int[] array = {1,2,3};
        System.out.println(arrayToString(array));
    }

    public static String arrayToString(int[] array){
        String s = "[";
        for (int i = 0; i < array.length; i++) {
            if(i==array.length-1){
                s+="word"+array[i]+"]";
            }else{
                s+="word"+array[i]+"#";
            }
        }
        return s;
    }
}
