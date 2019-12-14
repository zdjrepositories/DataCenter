package mapper;

import pojo.Category;
import pojo.Summary;

import java.util.ArrayList;

public interface CategoryMapper {
    /**
     * 插入数据
     * @param category
     */
    public void insertCategory(Category category);
    public ArrayList selectCategory() ;

}
