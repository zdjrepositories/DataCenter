package mapper;

import pojo.Ranges;

import java.util.ArrayList;
import java.util.Queue;

public interface RangesMapper {
    /**
     * 插入数据
     * @param ranges
     */
    public void insertRanges(Ranges ranges);
    public ArrayList selectRanges();


}
