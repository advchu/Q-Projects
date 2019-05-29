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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.anchore.model.ImageEntity;
import com.anchore.pojo.ImagePojo;
import com.anchore.pojo.VulnerablePojo;
import com.anchore.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
private static final String VUL_URL="http://localhost:8228/v1/images/by_id/";


@RequestMapping(value="/api/v1/images" ,method = RequestMethod.GET)
@ResponseBody
/*Authenticates servers counts to coordinates images with BasicAuth credentials.
 * Fetching all images in List from anchore engine.
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
	catch(Exception e) {
		 e.printStackTrace();
		LOGGER.log(Level.SEVERE, "Credentials Mismatched: {} "+e.getMessage());
		return null;	
		}

}

//Post's for Test only to DB connectivity from post for persistence//

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
/*
 * Services Exposing Response based upon it image_Id & vulnerablity
 * #image_Id
 * #vulnerablity time( it may surpass with os,non-os,all)
 * api reference:http://localhost:8088/api/images/by_id/831a029b6add43a7e2f88608a75bf1c924656d9622609fb96898b1f323002ad7/vuln/os
 */
@RequestMapping(value="/api/images/by_id/{imageId}/vuln/{vtype}",method = RequestMethod.GET)
@ResponseBody
public VulnerablePojo getVulnerableCheckWithType(@PathVariable("imageId") String imageId,
		                                         @PathVariable("vtype") String vtype) {      
/*
 *  
 */
	final String IMAGE_ID=imageId;
	final String VTYPE="/vuln/"+vtype;

try {		                                        	 
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth(environment.getProperty("cli-user"), environment.getProperty("cli-password"));
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
HttpEntity<Object> entity = new HttpEntity<Object>(headers);
LOGGER.info("#########Exposed Url###### " +VUL_URL+IMAGE_ID+VTYPE);
ObjectMapper mapper = new ObjectMapper();
return mapper.convertValue(restTemplate.exchange(VUL_URL+IMAGE_ID+VTYPE, 
		                                      HttpMethod.GET, entity ,Object.class).getBody(),
		                                                                       VulnerablePojo.class);
}

catch(HttpClientErrorException hcee) {
hcee.printStackTrace();
LOGGER.log(Level.SEVERE, "Credentials Mismatched: {} "+hcee.getMessage());
return null;	
}
catch(Exception e) {
	LOGGER.log(Level.SEVERE, "Exception Occurred : {} "+e.getStackTrace().toString());
	return null;	
	}

}

}//class

