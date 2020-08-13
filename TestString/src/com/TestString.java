package com;

public class TestString {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        equalString(s1,s2);

        String s3 = "11";
        String s4 = "11";
        equalString(s3,s4);

        String s5 = new String("11");
        String s6 = new String("11");;
        equalString(s5,s6);

        char[] char1 = {'1','1'};
        String s7 = new String(char1);
        String s8 = new String(char1);
        equalString(s7,s8);

        String s9 = new String();
        String s10 = new String();;
        equalString(s9,s10);
    }

    public static void equalString(String s1,String s2){
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println("==============================");
    }
}
