package Queue.impl;

import Queue.ProductQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ProductQueueImpl implements ProductQueue {
    private Queue<String> productQueue = new LinkedList<String>();

    /**
     * 初始化队列
     */
    @Override
    public void init() {

    }

    /**
     * 获取一个Product ID
     */
    @Override
    public String getProduct() {
        return null;
    }

    /**
     * 添加一个Product ID
     */
    @Override
    public void addProduct(String productid) {

    }
}
