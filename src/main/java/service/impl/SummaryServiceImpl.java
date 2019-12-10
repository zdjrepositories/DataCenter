package service.impl;

import mapper.SummaryMapper;
import service.SummaryService;

public class SummaryServiceImpl implements SummaryService {
    //private SummaryMapper summaryMapper;
    /**
     * 判断摘要值是否重复
     * @param id
     * @param content
     * @return
     */
    @Override
    public boolean isRepetition(String id, String content) {
        // String str=summaryMapper.selectSummary(id);


        return false;
    }
}
