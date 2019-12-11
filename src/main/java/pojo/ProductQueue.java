package pojo;

import java.util.LinkedList;
import java.util.Queue;

public interface ProductQueue {
    /**
     * 初始化队列
     */
    public void init();

    /**
     * 获取一个Product ID
     */
    public String getProduct();

    /**
     * 添加一个Product ID
     */
    public void addProduct(String product);

}
