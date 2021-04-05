package MyThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    public static void main(String[] args) {
        new PrintABC(5).printABC();
    }

    public PrintABC(int count) {
        this.count = count;
    }

    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    private int count;
    volatile int value = 0;

    public void printABC() {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }

    class ThreadA implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; ++i) {
                    while (value % 3 != 0)
                        conditionA.await();
                    System.out.print(" A ");
                    conditionB.signal();
                    value++;
                }
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadB implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; ++i) {
                    while (value % 3 != 1)
                        conditionB.await();
                    System.out.print(" B ");
                    conditionC.signal();
                    value++;
                }
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadC implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; ++i) {
                    while (value % 3 != 2)
                        conditionC.await();
                    System.out.print(" C ");
                    conditionA.signal();
                    value++;
                }
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }


}
