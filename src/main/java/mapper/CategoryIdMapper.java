package mapper;

import pojo.CategoryId;

import java.util.ArrayList;

public interface CategoryIdMapper {
    /**
     * 插入数据
     *
     * @param categoryId
     */
    public void insertCategoryId(CategoryId categoryId) ;
    public ArrayList selectCategoryId() ;

}
