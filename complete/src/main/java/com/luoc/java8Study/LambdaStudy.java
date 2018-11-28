package com.luoc.java8Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author luoc
 * @date 2018/11/27 0027
 * @Time 10:39
 */
public class LambdaStudy {

    public static void main(String[] args) {
        LambdaStudy lambdaStudy = new LambdaStudy();


        // 类型声明
        MathOpertion operation = (int a,int b) -> a+b;


        //不用类型声明
        MathOpertion subtraction = (a,b) -> a-b;

        //大括号中的返回语句
        MathOpertion multiplication = (int a,int b) -> {return  a*b; };

        // 没有大括号及返回语句

        MathOpertion division = (int a, int b) -> a/b;

        System.out.println("10 + 5 = " + lambdaStudy.operate(10,5,operation));
        System.out.println("10 - 5 = " + lambdaStudy.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaStudy.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaStudy.operate(10, 5, division));


        // 不用括号
        GreetingService greetingService = message ->
            System.out.println("Hello" + message);

        // 用括号
        GreetingService greetingService1 = (message) -> {
            System.out.println("Hello" + message);
        };


        greetingService.sayHell("Runoob");
        greetingService1.sayHell("Google");

        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Comparator<String> comparator = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players,comparator);


        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        // 方法引用
        names.forEach(System.out::println);

        //
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");
        eval(list, n->true);

        System.out.println("输出所有偶数:");
        eval(list,n -> n%2 == 0);



    }

    public  static  void eval(List<Integer> list,Predicate<Integer> predicate){
        list.parallelStream().filter(predicate).forEach(System.out::println);

    }

    interface MathOpertion{
        int operation(int a,int b);
    }

    interface  GreetingService{
        void sayHell(String message);
    }

    private  int operate(int a,int b,MathOpertion mathOpertion){
         return mathOpertion.operation(a,b);
    }
}
