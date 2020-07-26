package com.learining.diningphilosophers;

public class DeadLockRunner implements ThreadsRunner {

    public void runPhilosophers(){
        var preparation = new PhilosophersPreparation();
        Philosophers[] philosophers = preparation.preparePhilosophers(5);
        Object[] forks = new Object[philosophers.length];
        preparation.chooseForks(forks);
        for(int i = 0; i < philosophers.length; i++) {
            assignFork(philosophers, forks, i);
            Thread thread = new Thread(philosophers[i], "Philosopher " + (i + 1));
            thread.start();
        }
    }

    private void assignFork(Philosophers[] philosophers, Object[] forks, int i){
        Object leftFork = forks[i];
        Object rightFork = forks[(i + 1) % forks.length];
        philosophers[i] = new Philosophers(leftFork, rightFork);
    }
}
