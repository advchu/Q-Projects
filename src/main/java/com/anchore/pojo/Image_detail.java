package com.anchore.pojo;

public class Image_detail {

	
	
	 private String registry;

	    private String last_updated;

	    private String imageId;

	    private String dockerfile;

	    private String repo;

	    private String created_at;

	    private String fulltag;

	    private String userId;

	    private String imageDigest;

	    private String tag_detected_at;

	    private String fulldigest;

	    private String digest;

	    private String tag;

	    public String getRegistry ()
	    {
	        return registry;
	    }

	    public void setRegistry (String registry)
	    {
	        this.registry = registry;
	    }

	    public String getLast_updated ()
	    {
	        return last_updated;
	    }

	    public void setLast_updated (String last_updated)
	    {
	        this.last_updated = last_updated;
	    }

	    public String getImageId ()
	    {
	        return imageId;
	    }

	    public void setImageId (String imageId)
	    {
	        this.imageId = imageId;
	    }

	    public String getDockerfile ()
	    {
	        return dockerfile;
	    }

	    public void setDockerfile (String dockerfile)
	    {
	        this.dockerfile = dockerfile;
	    }

	    public String getRepo ()
	    {
	        return repo;
	    }

	    public void setRepo (String repo)
	    {
	        this.repo = repo;
	    }

	    public String getCreated_at ()
	    {
	        return created_at;
	    }

	    public void setCreated_at (String created_at)
	    {
	        this.created_at = created_at;
	    }

	    public String getFulltag ()
	    {
	        return fulltag;
	    }

	    public void setFulltag (String fulltag)
	    {
	        this.fulltag = fulltag;
	    }

	    public String getUserId ()
	    {
	        return userId;
	    }

	    public void setUserId (String userId)
	    {
	        this.userId = userId;
	    }

	    public String getImageDigest ()
	    {
	        return imageDigest;
	    }

	    public void setImageDigest (String imageDigest)
	    {
	        this.imageDigest = imageDigest;
	    }

	    public String getTag_detected_at ()
	    {
	        return tag_detected_at;
	    }

	    public void setTag_detected_at (String tag_detected_at)
	    {
	        this.tag_detected_at = tag_detected_at;
	    }

	    public String getFulldigest ()
	    {
	        return fulldigest;
	    }

	    public void setFulldigest (String fulldigest)
	    {
	        this.fulldigest = fulldigest;
	    }

	    public String getDigest ()
	    {
	        return digest;
	    }

	    public void setDigest (String digest)
	    {
	        this.digest = digest;
	    }

	    public String getTag ()
	    {
	        return tag;
	    }

	    public void setTag (String tag)
	    {
	        this.tag = tag;
	    }

		@Override
		public String toString() {
			return "Image_detail [registry=" + registry + ", last_updated=" + last_updated + ", imageId=" + imageId
					+ ", dockerfile=" + dockerfile + ", repo=" + repo + ", created_at=" + created_at + ", fulltag="
					+ fulltag + ", userId=" + userId + ", imageDigest=" + imageDigest + ", tag_detected_at="
					+ tag_detected_at + ", fulldigest=" + fulldigest + ", digest=" + digest + ", tag=" + tag
					+ ", getRegistry()=" + getRegistry() + ", getLast_updated()=" + getLast_updated()
					+ ", getImageId()=" + getImageId() + ", getDockerfile()=" + getDockerfile() + ", getRepo()="
					+ getRepo() + ", getCreated_at()=" + getCreated_at() + ", getFulltag()=" + getFulltag()
					+ ", getUserId()=" + getUserId() + ", getImageDigest()=" + getImageDigest()
					+ ", getTag_detected_at()=" + getTag_detected_at() + ", getFulldigest()=" + getFulldigest()
					+ ", getDigest()=" + getDigest() + ", getTag()=" + getTag() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

	   
}
