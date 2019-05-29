package com.anchore.pojo;

import java.util.Collection;
import java.util.List;

import com.anchore.model.Digest;

public class ImagePojo {
	private String repo;
	private String digest;
	private String tag;
	private String created_at;
	private Collection<Digest>dockerfile;
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
	
	public Collection<Digest> getDockerfile() {
		return dockerfile;
	}
	public void setDockerfile(Collection<Digest> dockerfile) {
		this.dockerfile = dockerfile;
	}
	public String getRepo() {
		return repo;
	}
	public void setRepo(String repo) {
		this.repo = repo;
	}
	@Override
	public String toString() {
		return "ImagePojo [repo=" + repo + ", digest=" + digest + ", tag=" + tag + ", created_at=" + created_at
				+ ", dockerfile=" + dockerfile + "]";
	}
	


}
