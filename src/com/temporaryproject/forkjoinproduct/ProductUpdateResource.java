package com.temporaryproject.forkjoinproduct;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ProductUpdateResource {

    public static List<Product> updateProductsParallely(List<Product> products){

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(task);

        do {
            System.out.println("**********************************************************\n");
            System.out.println("Main: Parallelism: "+ pool.getParallelism());
            System.out.println("Main: Active Threads: "+ pool.getActiveThreadCount());
            System.out.println("Main: Task Count: "+ pool.getQueuedTaskCount());
            System.out.println("Main: Steal Count: "+ pool.getStealCount());
            System.out.println("**********************************************************\n");
            try{
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if(task.isCompletedNormally()){
            System.out.printf("Main: The process has been completed normally.\n");
        }

        for( int i = 0;i< products.size(); i++){
            Product product = products.get(i);
            if( product.getPrice()!=12){
                System.out.println(product.toString());
            }
        }

        return products;
    }

    public static List<Product> updateProductsSequentially(List<Product> products) {

        updatePrices(products, 0.20);

        return products;
    }

    private static void updatePrices(List<Product> products, double increment){
        for (int i = 0; i< products.size(); i++){
            Product product = products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }

    public static void runModule(){
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(1000000);

        long paraStart = System.currentTimeMillis();
        ProductUpdateResource.updateProductsParallely(products);
        long paraEnd = System.currentTimeMillis();
        System.out.println(paraEnd-paraStart);

        long seqStart = System.currentTimeMillis();
        ProductUpdateResource.updateProductsSequentially(products);
        long seqEnd = System.currentTimeMillis();
        System.out.println(seqEnd-seqStart);
    }

}
