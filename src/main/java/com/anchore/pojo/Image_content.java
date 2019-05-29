package com.anchore.pojo;

import org.hibernate.metamodel.Metadata;

public class Image_content {
	private Metadata metadata;

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

	@Override
	public String toString() {
		return "Image_content [metadata=" + metadata + ", getMetadata()=" + getMetadata() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

   }