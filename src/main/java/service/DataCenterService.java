package service;

import java.util.Queue;

/**
 * 数据获取及处理
 */
public interface DataCenterService {

    /**
     * 获取数据
     *
     */
    public void  getData();
    public void  getData(String id);

    /**
     * 判断是否重复
     *
     */
    public boolean isRepeat(String id);

    /**
     * 未重复保存摘要
     *
     */
    public void Summary();

    /**
     * 解析数据
     */
    public void analyze();

    /**
     * 更新数据
     */
    public void upData();


}
