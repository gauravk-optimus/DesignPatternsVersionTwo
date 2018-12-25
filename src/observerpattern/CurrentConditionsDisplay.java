package observerpattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer{
	Observable observable; 
	private float temperature;
	private float humidity;
	private float pressure;
		
	public CurrentConditionsDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public void update(Observable obs, Object arg){
		if(obs instanceof WeatherData){
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPresure();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("temperature "+temperature+", humidity "+humidity+", pressure "+pressure);	
	}
}