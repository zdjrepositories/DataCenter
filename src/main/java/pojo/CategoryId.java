package pojo;

public class CategoryId {
    private Long category_id;
    private Integer count;
    private String category_name;
    private String original_name;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    @Override
    public String toString() {
        return "CategoryId{" +
                "category_id=" + category_id +
                ", count=" + count +
                ", category_name='" + category_name + '\'' +
                ", original_name='" + original_name + '\'' +
                '}';
    }
}
