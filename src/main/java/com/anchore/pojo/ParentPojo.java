package com.anchore.pojo;

import java.util.Arrays;
import java.util.List;

public class ParentPojo {
	

		private String last_updated;

	    private String analysis_status;

	    private String parentDigest;

	    private String analyzed_at;

	    private String annotations;

	    private String created_at;

	    private String image_status;

	    private String userId;

	    private Image_content image_content;

	    private String imageDigest;

	    private Image_detail[] image_detail;

	    private String image_type;

	    public String getLast_updated ()
	    {
	        return last_updated;
	    }

	    public void setLast_updated (String last_updated)
	    {
	        this.last_updated = last_updated;
	    }

	    public String getAnalysis_status ()
	    {
	        return analysis_status;
	    }

	    public void setAnalysis_status (String analysis_status)
	    {
	        this.analysis_status = analysis_status;
	    }

	    public String getParentDigest ()
	    {
	        return parentDigest;
	    }

	    public void setParentDigest (String parentDigest)
	    {
	        this.parentDigest = parentDigest;
	    }

	    public String getAnalyzed_at ()
	    {
	        return analyzed_at;
	    }

	    public void setAnalyzed_at (String analyzed_at)
	    {
	        this.analyzed_at = analyzed_at;
	    }

	    public String getAnnotations ()
	    {
	        return annotations;
	    }

	    public void setAnnotations (String annotations)
	    {
	        this.annotations = annotations;
	    }

	    public String getCreated_at ()
	    {
	        return created_at;
	    }

	    public void setCreated_at (String created_at)
	    {
	        this.created_at = created_at;
	    }

	    public String getImage_status ()
	    {
	        return image_status;
	    }

	    public void setImage_status (String image_status)
	    {
	        this.image_status = image_status;
	    }

	    public String getUserId ()
	    {
	        return userId;
	    }

	    public void setUserId (String userId)
	    {
	        this.userId = userId;
	    }

	    public Image_content getImage_content ()
	    {
	        return image_content;
	    }

	    public void setImage_content (Image_content image_content)
	    {
	        this.image_content = image_content;
	    }

	    public String getImageDigest ()
	    {
	        return imageDigest;
	    }

	    public void setImageDigest (String imageDigest)
	    {
	        this.imageDigest = imageDigest;
	    }

	    
	    public String getImage_type ()
	    {
	        return image_type;
	    }

	    public void setImage_type (String image_type)
	    {
	        this.image_type = image_type;
	    }

		public Image_detail[] getImage_detail() {
			return image_detail;
		}

		public void setImage_detail(Image_detail[] image_detail) {
			this.image_detail = image_detail;
		}

		
	

	 
		
}
