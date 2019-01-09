package com.luoc.java8Study;


import java.util.Optional;

/**
 * @author luoc
 * @date 2018/11/27 0027
 * @Time 15:08
 */
public class OptionalStudy {

    public static void main(String[] args) {
        OptionalStudy optionalStudy = new OptionalStudy();


        Integer values1 = null;
        Integer values2 = new Integer(10);

        // Optional.ofNullable - 允许传递为null参数
        Optional<Integer> a  = Optional.ofNullable(values1);

        //Optioanl.of -  如果传递的参数是null 抛出异常 nullEx
        Optional<Integer> b = Optional.of(values2);
        System.out.println(optionalStudy.sum(a,b));


    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        // Optional.isPresent - 判断值是否存在
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        Integer values2 = b.get();
        return  value1 + values2;

    }

}
