//package mac;
//
//
//// What are the wait() and notify() methods in multithreading . Can you please give me examples ?
//// Use above in chat gpt
//class SharedResource {
//    private int count = 0;
//    private boolean available = false;
//
//    // Synchronized method to produce items
//    public synchronized void produce() {
//        while (available) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//        count++;
//        System.out.println("Produced: " + count);
//        available = true;
//        notify();
//    }
//
//    // Synchronized method to consume items
//    public synchronized void consume() {
//        while (!available) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//        System.out.println("Consumed: " + count);
//        available = false;
//        notify();
//    }
//}
//
//class Producer extends Thread {
//    private final SharedResource resource;
//
//    public Producer(SharedResource resource) {
//        this.resource = resource;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            resource.produce();
//        }
//    }
//}
//
//class Consumer extends Thread {
//    private final SharedResource resource;
//
//    public Consumer(SharedResource resource) {
//        this.resource = resource;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            resource.consume();
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        SharedResource resource = new SharedResource();
//        Producer producer = new Producer(resource);
//        Consumer consumer = new Consumer(resource);
//
//        producer.start();
//        consumer.start();
//    }
//}
