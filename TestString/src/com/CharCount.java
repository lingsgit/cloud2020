package com;

import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        int countUpper=0;
        int countLower=0;
        int countNumber=0;
        int countOther=0;
        System.out.println("请输入字符串！");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        byte[] bytes = next.getBytes();
        for (int i = 0; i < chars.length; i++) {
            System.out.println("chars:"+chars[i]);
        }

        for (int i = 0; i < bytes.length; i++) {
            System.out.println("chars:"+bytes[i]);
        }
//        for (int i = 0; i < bytes.length; i++) {
//            if (bytes[i]>=48&&bytes[i]<=57){
//                countNumber++;
//            }else if(bytes[i]>=65&&bytes[i]<=90){
//                countUpper++;
//            }else if(bytes[i]>=97&&bytes[i]<=122){
//                countLower++;
//            }else{
//                countOther++;
//            }
//        }
//        System.out.println("数字个数为："+countNumber);
//        System.out.println("大写字母个数为："+countUpper);
//        System.out.println("小写字母个数为："+countLower);
//        System.out.println("其他个数为："+countOther);
    }
}
