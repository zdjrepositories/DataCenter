package pojo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Category {
    private Long id;
	private Date update_time;
    private String category_name;
	private String origin_name;
	private String picture_id;
	private String picture_desc;
	private Integer bu_id=0;

    @Override
    public String toString() {
        return "category{" +
                "id=" + id +
                ", update_time='" + update_time + '\'' +
                ", category_name='" + category_name + '\'' +
                ", origin_name='" + origin_name + '\'' +
                ", picture_id='" + picture_id + '\'' +
                ", picture_desc='" + picture_desc + '\'' +
                ", bu_id=" + bu_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpdate_time() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_desc() {
        return picture_desc;
    }

    public void setPicture_desc(String picture_desc) {
        this.picture_desc = picture_desc;
    }

    public Integer getBu_id() {
        return bu_id;
    }

    public void setBu_id(Integer bu_id) {
        this.bu_id = bu_id;
    }
}
