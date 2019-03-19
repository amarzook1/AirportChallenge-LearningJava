
import java.util.Random;

public class Weather {
    private String weather;

    public static void main(String[] args) {
        Weather weather = new Weather();
        Weather weather1 = new Weather("Stormy");
        System.out.println(weather1.getWeather());
        Weather weather2 = new Weather("Clear");
        System.out.println(weather2.getWeather());


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

    public Weather(String weather) {
        if(weather.equals("Clear") || weather.equals("Stormy")) {
            this.weather = weather;
        } else this.weather = "Clear";
    }

    public String getWeather() {
        return getRandomWeather();
    }

    private String getRandomWeather() {
        Random rand = new Random();
        if(this.weather.equals("")){
            int n = rand.nextInt(3);
            if(n == 0){
                this.weather = "Stormy";
            } else{
                this.weather = "Clear";
            }
        }

        return this.weather;
    }

}
