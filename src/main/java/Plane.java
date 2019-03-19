public class Plane {
    private String name;
    private boolean landed = false;

    public Plane(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLanded() {
        return landed;
    }

    public void setLanded(boolean landed) {
        this.landed = landed;
    }
}
