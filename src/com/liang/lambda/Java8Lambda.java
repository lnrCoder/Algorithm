package com.liang.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName Java8Lambda
 * @description java8 lambda 表达式
 * @Author https://www.cnblogs.com/anakin/p/7742779.html
 * @Date 2018/12/4
 */
public class Java8Lambda {

    public static void main(String[] args) {
        Java8Lambda lambda = new Java8Lambda();
        lambda.forList();
    }

    public void newThread() {
        new Thread(() -> System.out.println("new thread start!")).start();
    }

    public void forList() {
        List list = Arrays.asList("a", "b", "c", "d");
        list.forEach(n -> {
            System.out.printf("====%s====\n",n);
            System.out.println(n);
        });
        System.out.println("-------------------");
        list.forEach(System.out::println);
    }

    public void predicateAnd() {
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

        List names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("Name, which starts with'J' and four letter long is : " + n));
    }

    public void mapReduce() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + 0.12 * cost)
                .forEach(System.out::println);
    }
}
