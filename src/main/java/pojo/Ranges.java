package pojo;

import java.text.SimpleDateFormat;

public class Ranges {
    private Long id;
    private String range_name;
	private String origin_name;
	private Long picture_id;
	private String picture_desc;
	private String short_des;
	private Long category_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRange_name() {
		return range_name;
	}

	public void setRange_name(String range_name) {
		this.range_name = range_name;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public Long getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(Long picture_id) {
		this.picture_id = picture_id;
	}

	public String getPicture_desc() {
		return picture_desc;
	}

	public void setPicture_desc(String picture_desc) {
		this.picture_desc = picture_desc;
	}

	public String getShort_des() {
		return short_des;
	}

	public void setShort_des(String short_des) {
		this.short_des = short_des;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Ranges{" +
				"id=" + id +
				", range_name='" + range_name + '\'' +
				", origin_name='" + origin_name + '\'' +
				", picture_id=" + picture_id +
				", picture_desc='" + picture_desc + '\'' +
				", short_des='" + short_des + '\'' +
				", category_id=" + category_id +
				'}';
	}
}
