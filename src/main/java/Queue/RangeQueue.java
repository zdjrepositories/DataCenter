package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Range队列操作接口
 */
public interface RangeQueue {
    /**
     * 初始化队列
     */
    public void init();

    /**
     * 获取一个Range ID
     */
    public String getRange();

    /**
     * 添加一个Range ID
     */
    public void addRange(String rangId);

}
