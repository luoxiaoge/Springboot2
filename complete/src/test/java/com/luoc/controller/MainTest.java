package com.luoc.controller;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 17:48
 */
public class MainTest {


    public static void main(String[] args) {
       //1010
       /* System.out.println( 5 << 1);
        Son son = new  Son();
        System.out.println(son.getName());*/

        Map<String,Object>  map = new HashMap<>();
        Integer a = 1;
        map.put("a",a);
        map.put("b","b");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.stream().filter(ef -> ef-2 > 0).forEach(System.out::println);
        String setString = "luoc";
        Set<Object> collet = Stream.of(setString).filter(Objects::nonNull).collect(Collectors.toSet());


        Object[] arrayObject = collet.stream().map(Object::toString).toArray();
        System.out.println(JSON.toJSONString(arrayObject));
        System.out.println(JSON.toJSONString(collet));
        System.out.println(JSON.toJSONString(list));




        // 先转String 在转对应类型
        Byte b = Byte.valueOf(String.valueOf(map.get("a"))) ;
       // Byte c = Byte.

       // System.out.println(b);

    }


    private static void testCollection(){

        List<Integer> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        /**
         *  遍历时对集合进行操作会导致异常
         */
        for (Integer a:list) {
            if (a.equals(5)){
                list.remove(a);
            }
        }

        System.out.println(JSON.toJSONString(list));

    }

   /*   static class father{
        @Override
        public String toString() {
            return "luoc";
        }
    }


      static class  son extends father{
        public String  getName(){
            return  toString();
        }*/

        /* public String  getName2(){
               son.toString();
               return "aaa";
         }*/

   // }
}
