package com.gohan.button.worker;

import java.io.IOException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataPooling {
	
	@Autowired WebClient webClient;
    
    public String login() throws JsonProcessingException, IOException{
    	
    	StringBuilder path = new  StringBuilder();
    	path.append("/StandardApiAction_login.action");
    	webClient.query("account", "Milogps");
    	webClient.query("password", "REyrebo.2994");
        String result = webClient.path(path.toString()).get(String.class);
        System.out.println(result);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(result);
        System.out.println("JSON"+actualObj.get("jsession"));
    	//webClient.reset();
    	webClient.resetQuery();
        return actualObj.get("jsession").toString();
    }
    
    public String  getInfoVehicle(String sessionID) throws JsonProcessingException, IOException{
    	
    	StringBuilder path = new  StringBuilder();
    	path.append("/StandardApiAction_queryUserVehicle.action");
    	System.out.println("jsession" + sessionID );
    	
    	webClient.query("jsession", sessionID.trim().replace("\"",""));
    	System.out.println(path.toString());

        String result = webClient.replacePath(path.toString()).get(String.class);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(result);
        String vehicleID = actualObj.get("vehicles").get(0).get("dl").get(0).get("id").textValue();
        System.out.println(vehicleID);
 
		
    	webClient.reset();
    	webClient.resetQuery();
    	
    	return vehicleID;
    }
    
    public String getStatusAlarm(String sessionID, String vehicleID){
    	
    	StringBuilder path = new  StringBuilder();
    	path.append("/StandardApiAction_vehicleAlarm.action");
    	System.out.println("jsession" + sessionID );
    	System.out.println("DevIDNO" + vehicleID );
    	System.out.println("toMap" + 2 );

    	webClient.query("jsession", sessionID.trim().replace("\"",""));
    	webClient.query("DevIDNO", vehicleID);
    	webClient.query("toMap", 2);

    	System.out.println(path.toString());

        String result = webClient.replacePath(path.toString()).get(String.class);
        

        System.out.println(result);
 
		
    	webClient.reset();
    	webClient.resetQuery();
		return null;
    }
    
    
    public String logout(String sessionID){
    	
    	StringBuilder path = new  StringBuilder();
    	path.append("/StandardApiAction_logout.action");
    	System.out.println("jsession" + sessionID );

    	webClient.query("jsession", sessionID.trim().replace("\"",""));

    	System.out.println(path.toString());

        String result = webClient.replacePath(path.toString()).get(String.class);
        

        System.out.println(result);
 
		
    	webClient.reset();
    	webClient.resetQuery();
		return null;
    }
}
