package com.example.service;

public class Son extends Father{

    public void test(){
        System.out.print("儿子的test方法");
    }


    public static void main(String[] args){
        Father fa = new Son();
        fa.test();
        fa.eat();
    }
}
