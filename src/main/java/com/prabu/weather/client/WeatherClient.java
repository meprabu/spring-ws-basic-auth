package com.prabu.weather.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.weatherservice.prabu.GetWeather;
import com.weatherservice.prabu.GetWeatherResponse;

@Component
public class WeatherClient {
	
	
	 @Autowired
	  private WebServiceTemplate webServiceTemplate;
	 
	 private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

	  public String getWeatherByCity(String city, String country) {
		com.weatherservice.prabu.ObjectFactory factory = new com.weatherservice.prabu.ObjectFactory();
		GetWeather request = factory.createGetWeather();

			request.setCityName(city);
			request.setCountryName(country);
			
			LOGGER.info("Client sending person[city={},country={}]", request.getCityName(), request.getCountryName());
	        

			GetWeatherResponse response = (GetWeatherResponse) webServiceTemplate.marshalSendAndReceive(request);

	    LOGGER.info("Client received greeting='{}'", response.getGetWeatherResult());
	    return response.getGetWeatherResult();
	  }

}
