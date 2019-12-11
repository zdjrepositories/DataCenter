package queue;

public interface DataCenterQueue {
    /**
     * 初始化队列
     */
    public void init();

    /**
     * 获取一个ID
     */
    public String getItem();

    /**
     * 添加一个iD
     */
    public void addItem(String id);

    public String toString();
    public int size();
}
