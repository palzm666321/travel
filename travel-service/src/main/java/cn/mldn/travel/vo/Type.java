package cn.mldn.travel.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Type implements Serializable {
	private String tpid ;
	private String title ;
	public String getTpid() {
		return tpid;
	}
	public void setTpid(String tpid) {
		this.tpid = tpid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Type [tpid=" + tpid + ", title=" + title + "]";
	}

}
