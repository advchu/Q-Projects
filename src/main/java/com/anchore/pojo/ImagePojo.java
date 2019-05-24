package com.anchore.pojo;

public class ImagePojo {
	private String digest;
	private String tag;
	private String created_at;
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "ImagePojo [digest=" + digest + ", tag=" + tag + ", created_at=" + created_at + "]";
	}


}
