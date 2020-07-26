package com.learining.diningphilosophers;

public class Philosophers implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosophers(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                doingPhilosopherThing(" " + " thinking");
                synchronized (leftFork) {
                    doingPhilosopherThing(" " + " picking left fork");
                    synchronized (rightFork) {
                        doingPhilosopherThing(" " + " picking right fork");
                        doingPhilosopherThing(" " + " eating");
                        doingPhilosopherThing(" " + " put down right fork");
                    }
                    doingPhilosopherThing(" " + " put down left fork. Back to thinking.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    private void doingPhilosopherThing(String action) throws InterruptedException {
        Thread.sleep(300+ (int)(Math.random()*700));
        System.out.println(" "+Thread.currentThread().getName() +action);
    }
}
