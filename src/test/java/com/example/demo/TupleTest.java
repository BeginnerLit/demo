package com.example.demo;

public class TupleTest {
    static Tuple f2(){
        return new Tuple("hi",47);
    }

    static Tuple<String,Integer>f(){
        return new Tuple<>("hi",47);
    }

    public static void main(String[] args) {
        Tuple<String,Integer> f1=f();
        Tuple f2=f();
        f1=f2;
        System.out.println(f1.getOne());
    }
}
