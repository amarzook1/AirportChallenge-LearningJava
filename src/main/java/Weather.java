
import java.util.Random;

public class Weather {
    private String weather;

    public static void main(String[] args) {
        Weather weather = new Weather();
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
        System.out.println(weather.getWeather());
    }

    public Weather() {
        this.weather = "";
    }


    public String getWeather() {
        return getRandomWeather();
    }

    private String getRandomWeather() {
        Random rand = new Random();

        int n = rand.nextInt(3);
        if(n == 0){
            this.weather = "Stormy";
        } else{
            this.weather = "Clear";
        }

        return this.weather;
    }

}
