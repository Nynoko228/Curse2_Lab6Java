package com.company;

import java.lang.Thread;
import java.util.stream.LongStream;

class Threads implements Runnable{
    @Override
    public void run() {
        Main.ISum sum = (a, b) -> a + b;
        Main.IMul mul = (a, b) -> a * b;
        Main.IFac fac = (a, b) -> {
            a = 1;
            for (int i = 1; i <= b; i++){
                a *= i;
            }
            return a;
        };
        Main.IExp exp = (a, b) -> {
            int c = a;
            for (int i = 1; i < b; i ++){
                a *= c;
            }
            return a;
        };
//        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " Сумма: " +sum.sum(2, 4));
        System.out.println(Thread.currentThread().getName() +  " Произведение: " +mul.mul(2, 4));
        System.out.println(Thread.currentThread().getName() +  " Факториал: " +fac.fac(2, 4));
        System.out.println(Thread.currentThread().getName() +  " Возведение в степень: " +exp.exp(2, 4));
    }
}

public class Main {

    public static void main(String[] args){
        Thread thr1 = new Thread(new Threads());
        thr1.start();

        Thread thr2 = new Thread(new Threads());
        thr2.start();

    }
    @FunctionalInterface
    public interface ISum{
        public int sum(int a, int b);
    }
    @FunctionalInterface
    public interface IFac{
        public int fac(int a, int b);
    }
    @FunctionalInterface
    public interface IExp{
        public int exp(int a, int b);
    }
    @FunctionalInterface
    public interface IMul{
        public int mul(int a, int b);
    }

//    public static class MyThread extends Thread{
//        public void run(){
//            System.out.println("Hello wrd!");
//        }
//    }
//
//    class PeopleQ extends Thread{
//        private String[] names;
//
//        PeopleQ(String... names){
//            this.names = names;
//        }
//
//        //Ну тут надо переписать метод run() (так-то любуые несколько строчек sout'а написать можно, чтобы увидеть работу
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Thread curThr = Thread.currentThread();
//        System.out.println("Thread: " + curThr.getName());
//        System.out.println("Thread croup: " + curThr.getThreadGroup().getName());
//        System.out.println("Parent Croup: " + curThr.getThreadGroup().getParent().getName());
//        Thread thr = new MyThread();
//        thr.run();
//    }
}

