package cn.mldn.travel.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private String iid;
	private String title;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
