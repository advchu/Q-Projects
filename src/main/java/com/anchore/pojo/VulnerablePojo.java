package com.anchore.pojo;

public class VulnerablePojo {
private String imageDigest;
private String [] vulnerabilities;
private String vulnerability_type;
public String getImageDigest() {
	return imageDigest;
}
public void setImageDigest(String imageDigest) {
	this.imageDigest = imageDigest;
}
public String[] getVulnerabilities() {
	return vulnerabilities;
}
public void setVulnerabilities(String[] vulnerabilities) {
	this.vulnerabilities = vulnerabilities;
}
public String getVulnerability_type() {
	return vulnerability_type;
}
public void setVulnerability_type(String vulnerability_type) {
	this.vulnerability_type = vulnerability_type;
}


}
