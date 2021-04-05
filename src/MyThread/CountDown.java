package MyThread;

import java.util.concurrent.CountDownLatch;

public class CountDown {

    CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new CountDown().print();

    }


    public void print() throws InterruptedException {
        new Thread(new FirstPrint()).start();
        latch.await();
        System.out.println("BBBBBBBB");
    }


    class FirstPrint implements Runnable {

        @Override
        public void run() {
            System.out.println("AAAAAAAAAAA");
            try {
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
