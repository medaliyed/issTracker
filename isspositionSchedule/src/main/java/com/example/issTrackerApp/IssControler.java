package com.example.issTrackerApp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class IssControler {
	
	@Autowired
	IssRepository issRepo;
	
	
	@GetMapping("/last10Iss")
	@ResponseBody
	public List<Iss> getAllTracks() {
		System.out.println("getting all tracks");
		//System.out.println(repo.findAll());
		//Gson gson=new GsonBuilder().create();
		//String json = gson.toJson(issRepo.showLast10issPos());
		List<Iss> resultOf10 = null;
		try {
			 resultOf10 = issRepo.showLast10issPos();
			System.out.println(resultOf10);
		} catch (Exception e) {
			System.out.println(e);  
			resultOf10 = null;
		}
		
		return resultOf10;
		//return json;
		//List<Iss> tt = issRepo.showLast10issPos();
		//return new ResponseEntity<Iss>(tt, HttpStatus.OK);
	}
	
	
	/*
	 * this method is to add the coordonates of iss every 5 sec*/
	//@GetMapping("/add")
	@ResponseBody
	@Scheduled(fixedRate = 5000)
	public Integer addIssPostion() {
		System.out.println("adding a new position");
		
		RestTemplate restTemplate = new RestTemplate();
		try {
			
			JsonNode isstrack = restTemplate.getForObject("http://api.open-notify.org/iss-now.json", JsonNode.class);
			
			
			Iss iss = new Iss(isstrack.get("timestamp").asInt(),
					isstrack.get("message").asText(),
					isstrack.at("/iss_position/latitude").asDouble(),
					isstrack.at("/iss_position/longitude").asDouble());
			System.out.println(iss.toString());
			System.out.println(ResponseEntity.status(HttpStatus.CREATED).build());
			return issRepo.saveIssPos(iss);

		} catch (Exception e) {
			System.out.println("Handling of this  "+ e);
			//logger.warn("Handling of [" + ex.getClass().getName() + "] esulted in Exception", handlerException);
		}
		return null;
	}

}
