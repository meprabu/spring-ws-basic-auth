package com.prabu.weather;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.prabu.weather.client.WeatherClient;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class WeatherApplicationTests {

	@Autowired
	WeatherClient weatherClient;
	
	@Test
	public void contextLoads() {
	}
	
		@Test
	  public void testgetWeather() {
	    assertThat(weatherClient.getWeatherByCity("chennai", "India")).isEqualTo("98 deg farenheit");
	  }

}
