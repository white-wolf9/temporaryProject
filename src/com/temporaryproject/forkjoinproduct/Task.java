package com.temporaryproject.forkjoinproduct;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Task extends Recursive action and is used to update the product list recursively.
 */
public class Task extends RecursiveAction {

    private List<Product> productList;
    private int first;
    private  int last;

    private double increment;

    /**
     * For the task that is created, the list of products are accepted, first and last denote the range of products
     * to be considered for the update process, the increment is the value of the increment required.
     * @param products
     * @param first
     * @param last
     * @param increment
     */
    public Task(List<Product> products, int first, int last, double increment) {
        this.productList = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 1000000) {
            updatePrices();
        }
        else {
            int middle = (last+first)/2;
            System.out.println("Task: Pending tasks: "+getQueuedTaskCount()+"\n");
            Task task1 =  new Task(productList, first,middle+1, increment);
            Task task2 =  new Task(productList,middle+1, last, increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrices(){
        for (int i = first; i< last; i++){
            Product product = productList.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }

}
