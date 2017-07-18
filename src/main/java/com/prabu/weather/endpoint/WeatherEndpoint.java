package com.prabu.weather.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.weatherservice.prabu.GetWeather;
import com.weatherservice.prabu.GetWeatherResponse;

@Endpoint
public class WeatherEndpoint {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(WeatherEndpoint.class);
	  private static final String NAMESPACE_URI = "http://www.prabu.weatherservice.com";
	  
	  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetWeather")
	  @ResponsePayload
	  public GetWeatherResponse sayHello(@RequestPayload GetWeather request) {
	    LOGGER.info("Endpoint received person[firstName={},lastName={}]", request.getCityName(),
	        request.getCountryName());

	    com.weatherservice.prabu.ObjectFactory factory = new com.weatherservice.prabu.ObjectFactory();
	    GetWeatherResponse response = factory.createGetWeatherResponse();
	    response.setGetWeatherResult("98 deg farenheit");

	  
	    return response;
	  }

}
