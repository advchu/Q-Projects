package com.anchore.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
/*
 * created by RK.Nayak
 * May 24/2019
 * 
 */
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.anchore.helper.HibernateUtil;
import com.anchore.model.Digest;
import com.anchore.model.ImageEntity;
import com.anchore.pojo.ImagePojo;
import com.anchore.pojo.ParentPojo;

@Service
public class ImageService {
@Autowired
private RestTemplate restTemplate;
@Autowired
private Environment environment;
private static final  Logger LOGGER=Logger.getLogger(ImageService.class.getName());

public  List<ImageEntity> saveImageDetails(final ImagePojo imagePojo) {
	LOGGER.info("############saving Image Details##############");
    Session ses=HibernateUtil.getSessionFactory().openSession();
 	ImageEntity imageEntity=new ImageEntity();
 	imageEntity.setDigest(imagePojo.getDigest());
 	imageEntity.setTag(imagePojo.getTag());
	imageEntity.setCreated_at(imagePojo.getCreated_at());
	Digest digest=new Digest();
	digest.setStatus(imagePojo.getDockerfile().stream().iterator().next().getStatus());
	imageEntity.getlistOfDigest().add(digest);
	try {
		/*
		 * we need to handle here for unnatural exception occurences
		 */
	Transaction tx=ses.beginTransaction();
	LOGGER.info("####Transaction begins for images######"+imagePojo.toString());
	ses.save(imageEntity);
  	tx.commit();

}
	catch(Exception e) {
		LOGGER.log(Level.WARNING, ">>>>>>transaction Failied<<<<<<<<<<");;
		e.printStackTrace();
	
	}
 LOGGER.log(Level.CONFIG, "########Query Executed #######");		
  List<ImageEntity>list= ses.createQuery("from ImageEntity").list();
  return list;
}

private static ImagePojo  transform( final LinkedHashMap[] listObjects) {
	ImagePojo pojo=new ImagePojo();
	ParentPojo parentPojo=new ParentPojo();
	for (LinkedHashMap<String, Object>list:listObjects) {
	 
	}
	
		
	return pojo;
}







}
