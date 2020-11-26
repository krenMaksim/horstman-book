package com.kren.horstman.book.volume1.chapter12.concurrency.tasks.and.threads.pools;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CallableMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);

        List<Task> tasks = IntStream.range(1, 10)
                                    .mapToObj(Task::new)
                                    .collect(Collectors.toUnmodifiableList());

        service.invokeAll(tasks)
               .forEach(future -> {
                   try {
                       System.out.println(future.get());
                   } catch (InterruptedException | ExecutionException e) {
                       e.printStackTrace();
                   }
               });

        System.out.println("Service shutdown");

        service.shutdown();
    }

    static class Task implements Callable<String> {

        private final int id;

        public Task(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            System.out.println(id + " Run task " + Thread.currentThread().getName());
                                                        
            TimeUnit.SECONDS.sleep(3);
            return id +"__" + System.currentTimeMillis();
        }
    }
}
