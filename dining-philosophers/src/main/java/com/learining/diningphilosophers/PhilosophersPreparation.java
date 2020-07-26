package com.learining.diningphilosophers;

public class PhilosophersPreparation {

    public void chooseForks(Object[] forks){
        for(int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
    }

    public Philosophers[] preparePhilosophers(int i){
        return new Philosophers[i];
    }
}
