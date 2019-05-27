/*
 * @author R.Nayak 
 * May/24/2019
 * This Api's identifies images and all services to exposes anchore images info.
 */
package com.anchore.endpoint;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.anchore.model.ImageEntity;
import com.anchore.pojo.ImagePojo;
import com.anchore.service.ImageService;
@RestController
public class ImageController {
@Autowired
private ImageService imageService;
@Autowired
private RestTemplate restTemplate;
@Autowired
private Environment environment;

private static final  Logger LOGGER=Logger.getLogger(ImageController.class.getName());
private static final String ENDPOINT_URL="http://localhost:8228/v1/images";
@RequestMapping(value="/api/v1/images" ,method = RequestMethod.GET)
@ResponseBody
/*Authenticates servers counts to coordinates images with BasicAuth credentials.
 * 
 * 
 */
public Object[] getCompleteImageDetails() {
    LOGGER.info("########Images Details Fetching##############");
	try {
	HttpHeaders headers = new HttpHeaders();
	headers.setBasicAuth(environment.getProperty("cli-user"), environment.getProperty("cli-password"));
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity <Object[]> entity = new HttpEntity<Object[]>(headers);
    return restTemplate.exchange(ENDPOINT_URL, HttpMethod.GET, entity , Object[].class).getBody();
    }
	catch(HttpClientErrorException hcee) {
	hcee.printStackTrace();
	LOGGER.log(Level.SEVERE, "Credentials Mismatched: {} "+hcee.getMessage());
	return null;	
	}
}


@RequestMapping(value="/api/image" ,method = RequestMethod.POST)
@ResponseBody
public List<ImageEntity>getReponseImage(@RequestBody ImagePojo imagePojo){
       List<ImageEntity>actualValue=null;
       LOGGER.info("#######Requested Body########");
       if(imagePojo!=null) {
        actualValue=imageService.saveImageDetails(imagePojo);
       LOGGER.info("#######Added saved to POJO into List########"+actualValue.toString());
}
return actualValue;  	
}
}
