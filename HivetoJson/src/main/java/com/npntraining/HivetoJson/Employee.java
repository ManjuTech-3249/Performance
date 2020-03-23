package com.npntraining.HivetoJson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	
	@JsonProperty
	String ename;
	
	@JsonProperty
	int age;
}
