package Assignment;

/*
9. Write a Java program that implements a producer-consumer model using
multithreading. The program should have a producer thread that generates random
numbers and adds them to a queue, and a consumer thread that reads numbers
from the queue and calculates their sum. The program should use synchronization to
ensure that the queue is accessed by only one thread at a time.

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Question9 {
    private static final int QUEUE_CAPACITY = 10;
    private static final int NUM_ITEMS_TO_PRODUCE = 20;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Object lock = new Object();

        Producer producer = new Producer(queue, lock);
        Consumer consumer = new Consumer(queue, lock);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Producer implements Runnable {
        private Queue<Integer> queue;
        private Object lock;
        private Random random;

        public Producer(Queue<Integer> queue, Object lock) {
            this.queue = queue;
            this.lock = lock;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_ITEMS_TO_PRODUCE; i++) {
                synchronized (lock) {
                    while (queue.size() >= QUEUE_CAPACITY) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int randomNumber = random.nextInt(100);
                    queue.offer(randomNumber);
                    System.out.println("Produced: " + randomNumber);

                    lock.notifyAll();
                }

                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private Queue<Integer> queue;
        private Object lock;

        public Consumer(Queue<Integer> queue, Object lock) {
            this.queue = queue;
            this.lock = lock;
        }

        @Override
        public void run() {
            int sum = 0;

            for (int i = 0; i < NUM_ITEMS_TO_PRODUCE; i++) {
                synchronized (lock) {
                    while (queue.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int number = queue.poll();
                    System.out.println("Consumed: " + number);
                    sum += number;

                    lock.notifyAll();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Sum of consumed numbers: " + sum);
        }
    }
}
