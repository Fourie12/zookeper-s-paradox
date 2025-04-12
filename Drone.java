public class Drone {

    int distance_capacity;

    public Drone(int dc) {
        distance_capacity = dc;
    }

    public void setCapacity(int new_dc) {
        distance_capacity = new_dc;
    }

    public int getCapacity() {
        return distance_capacity;
    }
}
