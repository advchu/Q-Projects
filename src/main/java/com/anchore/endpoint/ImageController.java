/*
 * @author R.Nayak 
 * May/24/2019
 * This Api's identifies images and all services to exposes anchore images info.
 */
package com.anchore.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchore.model.ImageEntity;
import com.anchore.pojo.ImagePojo;
import com.anchore.service.ImageService;


@RestController
public class ImageController {
@Autowired
private ImageService imageService;
private static final  Logger LOGGER=Logger.getLogger(ImageController.class.getName());


@RequestMapping(value="/api/image" ,method = RequestMethod.POST)
@ResponseBody
public List<ImagePojo>getReponseImage(@RequestBody ImagePojo imagePojo){
final List<ImagePojo>listImages= new ArrayList<>();
LOGGER.info("#######Requested Body########");
LOGGER.info("--> {}"+imagePojo.getDigest());
LOGGER.info("--> {}"+imagePojo.getCreated_at());
LOGGER.info("--> {}"+imagePojo.getTag());
if(imagePojo!=null) {
ImagePojo actualPojo=imageService.saveImageDetails(imagePojo);
LOGGER.info("#######Adding POJO to List########"+actualPojo.toString());
listImages.add(actualPojo); 
LOGGER.info("ADDED to LIST and Size is :::::::"+listImages.size());
}
return listImages;  	
}
}
