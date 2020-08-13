package com;

import java.util.*;

public class DiZhu {
    public static void main(String[] args) {
        //准备
        String[] colorsa={"♥","♦","♣","♠"};
        List<String> colors = Arrays.asList(colorsa);
        String[] pai = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        List<String> numbers = Arrays.asList(pai);
        //存储牌索引
        List<Integer> pokerIndex=new ArrayList<>();
        //存储牌
        Map<Integer,String> poker = new HashMap<>();
        //牌索引
        int index=0;
        //添加大小王
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;

        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        for (int i = 0; i < colors.size(); i++) {
            for (int i1 = 0; i1 < numbers.size(); i1++) {
                poker.put(index,colors.get(i)+numbers.get(i1));
                pokerIndex.add(index);
                index++;
            }
        }
        System.out.println(poker);
        //洗牌
        Collections.shuffle(pokerIndex);

        //发牌
        List<Integer> player1=new ArrayList<>();
        List<Integer> player2=new ArrayList<>();
        List<Integer> player3=new ArrayList<>();
        List<Integer> dipai=new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer integer = pokerIndex.get(i);
            if(i>=51){
                dipai.add(integer);
            }else{
                if(i%3==0){
                    player1.add(integer);
                }
                if(i%3==1){
                    player2.add(integer);
                }
                if(i%3==2){
                    player3.add(integer);
                }
            }
        }


       //顺序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        //看牌
        System.out.println("玩家1");
        show(poker,player1);
        System.out.println("玩家2");
        show(poker,player2);
        System.out.println("玩家3");
        show(poker,player3);
        System.out.println("底牌");
        show(poker,dipai);

//        System.out.print("玩家1:");
//        for (int i = 0; i < player1.size(); i++) {
//            System.out.print(poker.get(player1.get(i))+" ");
//        }
//        System.out.println();
//        System.out.println("========================================");
//        //看牌
//        System.out.print("玩家2:");
//        for (int i = 0; i < player2.size(); i++) {
//            System.out.print(poker.get(player2.get(i))+" ");
//        }
//        System.out.println();
//        System.out.println("========================================");
//        //看牌
//        System.out.print("玩家3:");
//        for (int i = 0; i < player3.size(); i++) {
//            System.out.print(poker.get(player3.get(i))+" ");
//        }
//        System.out.println();
//        System.out.println("========================================");
//
//        for (int i = 0; i < dipai.size(); i++) {
//            System.out.print(poker.get(dipai.get(i)));
//        }
    }

    public static void show(Map poker,List index){
        for (int i = 0; i < index.size(); i++) {
            System.out.print(poker.get(index.get(i))+" ");
        }
        System.out.println();
        System.out.println("========================================");
    }
}
