package com.web.springbootweb.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/19 11:45
 */

/**
 * CountDownLatch的简单使用
 *
 */
public class MultiThreadListProcessingDemo {

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 4; // 设置线程数量
        List<Integer> dataList = createLargeList(); // 创建大 List 数据

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);

        int chunkSize = dataList.size() / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? dataList.size() : (i + 1) * chunkSize;

            List<Integer> subList = dataList.subList(start, end);

            executor.execute(new ProcessingTask(subList, latch));
        }

        executor.shutdown();
        latch.await(); // 等待所有任务完成

        System.out.println("All processing tasks have completed.");
    }

    private static List<Integer> createLargeList() {
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            dataList.add(i);
        }
        return dataList;
    }
}

class ProcessingTask implements Runnable {
    private List<Integer> dataList;
    private CountDownLatch latch;

    public ProcessingTask(List<Integer> dataList, CountDownLatch latch) {
        this.dataList = dataList;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Task is processing " + dataList.size() + " elements.");
        // 在这里执行对 dataList 的处理逻辑，可以是排序、过滤、计算等操作
        System.out.println(Thread.currentThread().getName()+" 在执行");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown(); // 操作完成后减少 CountDownLatch 的计数器
    }
}

