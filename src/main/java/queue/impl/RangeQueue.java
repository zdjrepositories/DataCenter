package queue.impl;


import queue.DataCenterQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Range队列操作类
 */
public class RangeQueue implements DataCenterQueue {
    private  Queue<String> rangeQueue;
    private  Integer rangesum;

    public RangeQueue(){
        super();
        init();
    }
    /**
     * 初始化队列
     */
    public void init() {
        rangeQueue=new LinkedList<String>();
        rangesum=0;
    }

    /**
     * 获取一个ID
     */
    @Override
    public String getItem() {
        String poll=rangeQueue.poll();
        return poll;
    }

    /**
     * 添加一个ID
     *
     * @param id
     */
    @Override
    public void addItem(String id) {
        rangeQueue.add(id);
        rangesum++;
    }

    @Override
    public int size() {
        return  rangeQueue.size();

    }


}
