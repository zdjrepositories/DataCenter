package mapper;

import pojo.Updata;

public interface UpdataMapper {

    /**
     *查询上次Bu数据量
     */
    public int selectLastBu();
    /**
     *查询上次Bu数据量
     */
    public int selectLastCat();
    /**
     *查询上次Bu数据量
     */
    public int selectLastSubcat();
    /**
     *查询上次Bu数据量
     */
    public int selectLastRange();
    /**
     *查询上次Bu数据量
     */
    public int selectLastPrducts();
    /**
     *查询上次数据数据量
     */
    public Updata selectLastUpdata();

}
