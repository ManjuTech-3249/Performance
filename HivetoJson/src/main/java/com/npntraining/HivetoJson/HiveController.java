package com.npntraining.HivetoJson;


import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npntraining.scala_test.MariaDBExample;


@RestController
@EnableAutoConfiguration
public class HiveController {
	
	 
	@RequestMapping(value = "/employee/{country_code}", method = RequestMethod.GET)
	 public String getEmployee(@PathVariable("country_code") String country_code){
		 
		 JSONObject obj = new JSONObject();
		 obj = MariaDBExample.getJSONData(country_code);
		 System.out.println(obj);
		return obj.toString();
		 
	 }
}
