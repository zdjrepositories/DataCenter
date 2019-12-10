package mapper;

import pojo.Summary;

public interface SummaryMapper {
    /**
     * 插入摘要
     * @param summary
     */
    public void insertSummary(Summary summary);

    /**
     * 通过摘要编号查询
     * @param id
     * @return
     */
    public Summary selectSummary(String id);

}
