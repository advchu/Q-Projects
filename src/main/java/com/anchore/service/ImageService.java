package com.anchore.service;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.anchore.helper.HibernateUtil;
import com.anchore.model.ImageEntity;
import com.anchore.pojo.ImagePojo;

@Service
public class ImageService {
private static final  Logger LOGGER=Logger.getLogger(ImageService.class.getName());

public ImagePojo saveImageDetails(final ImagePojo imagePojo) {
	LOGGER.info("############saving Image Details##############");
    Session ses=HibernateUtil.getSessionFactory().openSession();
 	ImageEntity imageEnity=new ImageEntity();
 	imageEnity.setDigest(imagePojo.getDigest());
 	imageEnity.setTag(imagePojo.getTag());
	imageEnity.setCreated_at(imagePojo.getCreated_at());
	try {
		/*
		 * we need to handle here for unnatural exception occurences
		 */
	Transaction tx=ses.beginTransaction();
	LOGGER.info("####Transaction begins for images######"+imagePojo.toString());
	ses.save(imageEnity);
  	tx.commit();
	ses.clear();
	ses.close();
	
}
	catch(Exception e) {
		e.printStackTrace();
	
	}
	ModelMapper mapper=new ModelMapper();
	ImagePojo mappedPojo=mapper.map(imageEnity, ImagePojo.class);
    LOGGER.info("mapped Object after Model Mapper---->"+mappedPojo.toString());
    return mappedPojo;
	
	
}

}
