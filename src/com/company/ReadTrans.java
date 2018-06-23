package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadTrans implements Runnable {
    private MoveAsstets moveAsstets;
    private Lock lock = new ReentrantLock();

    ReadTrans(MoveAsstets moveAsstets) {
        this.moveAsstets = moveAsstets;
    }

    @Override
    public void run () {
        lock.tryLock();
        moveAsstets.createTransact();
        lock.unlock();
    }
}
