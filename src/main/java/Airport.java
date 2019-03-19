//    As an air traffic controller
//    To ensure safety
//    I want to prevent landing when the airport is full


import java.util.ArrayList;

public class Airport {
    private String name;
    private int capacity;
    private ArrayList<Plane> planes = new ArrayList();

    public Airport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public boolean landPlane(Plane plane, Weather weather) {
        if(weather.getWeather().equals("Stormy")){
            System.out.println("The Current weather is " + weather.getWeather() + " Not safe for landing");
            return false;
        }

        if((planes.size() + 1 ) > this.capacity){
            System.out.println("Hanger at full capacity of " + this.capacity + " unable to land plane");
            return false;
        }

        if(plane.isLanded()){
            System.out.println("Plane is already landed");
            return false;
        }

        System.out.println("The Current weather is " + weather.getWeather() + " perfectly safe for landing");
        plane.setLanded(true);
        planes.add(plane);
        System.out.println(this.planes.size() + " in hanger");
        return true;
    }

    public void takeOff(String planeName, Weather weather){
        if(weather.getWeather().equals("Stormy")){
            System.out.println("The Current weather is " + weather.getWeather() + " Not suitable for takeoff");
            return;
        }
        System.out.println("The Current weather is " + weather.getWeather() + " Perfect Flying Weather");
        int planePosition = findPlane(planeName);
        if(planePosition < 0){
            System.out.println("Plane does not exist");
            return;
        }
        if(!(this.planes.get(planePosition).isLanded())){
            System.out.println("Plane has already taken off");
            return;
        }
        System.out.println(planeName + " has taken off from " + this.name + " Airport");
        this.planes.remove(planePosition);
    }

    private int findPlane(String planeName){

        for(int i = 0; i < this.planes.size(); i++){
            String tempPlaneName = this.planes.get(i).getName();
            if(tempPlaneName.equals(planeName)){
                return i;
            }
        }

        return -1;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
