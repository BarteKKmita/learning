package com.learining.diningphilosophers;

public class Main {
    public static void main(String[] args){
        ThreadsRunner runner = new PhilosophersRunner();
        runner.runPhilosophers();

//        ThreadsRunner deadLockRunner = new DeadLockRunner();
//        deadLockRunner.runPhilosophers();
    }
}
