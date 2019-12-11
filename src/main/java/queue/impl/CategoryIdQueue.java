package queue.impl;

import queue.DataCenterQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CategoryIdQueue implements DataCenterQueue {
    private Queue<String> categoryIdQueue;
    private  Integer categoryIdsum;

    public CategoryIdQueue(){
        super();
        init();
    }

    public int size(){
        return categoryIdQueue.size();
    }
    /**
     * 初始化队列
     */
    @Override
    public void init() {
        categoryIdQueue= new LinkedList<String>();
        categoryIdsum=0;
    }

    /**
     * 获取一个ID
     */
    @Override
    public String getItem() {
        return categoryIdQueue.poll();
    }

    /**
     * 添加一个iD
     *
     * @param id
     */
    @Override
    public void addItem(String id) {
        categoryIdQueue.add(id);
        categoryIdsum++;
    }
    @Override
    public String toString(){
        return categoryIdQueue.toString();
    }

}
