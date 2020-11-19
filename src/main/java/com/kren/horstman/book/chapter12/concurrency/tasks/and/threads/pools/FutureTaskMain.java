package com.kren.horstman.book.chapter12.concurrency.tasks.and.threads.pools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class FutureTaskMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);

        FutureTask<String> ft = new FutureTask<>(new CallableMain.Task(42));
        service.execute(ft);
        System.out.println("ExecutorService start");

        System.out.println("FutureTask isDone status : " + ft.isDone());

        String ftResult = ft.get();

        System.out.println("FutureTask get : " + ftResult);

        System.out.println("FutureTask isDone status : " + ft.isDone());
        System.out.println("Service shutdown");

        service.shutdown();
    }
}
