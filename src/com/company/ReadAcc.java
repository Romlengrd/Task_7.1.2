package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadAcc extends Thread {
    private MoveAsstets moveAsstets;
    private Lock lock = new ReentrantLock();

    ReadAcc(MoveAsstets moveAsstets) {
        this.moveAsstets = moveAsstets;
    }

    @Override
    public void run () {
        lock.tryLock();
        moveAsstets.createAccounts();
        lock.unlock();
    }
}
