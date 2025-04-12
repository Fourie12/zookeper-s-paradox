public class Drone {

    int distance_capacity;

    final int HERBI = 0;
    final int CARNI = 1;
    final int OMNI = 2;
    final int NOTHING = 3;

    int carrying;

    public Drone(int dc) {
        distance_capacity = dc;
    }

    public void setCapacity(int new_dc) {
        distance_capacity = new_dc;
    }

    public int getCapacity() {
        return distance_capacity;
    }

    public void setCarry(int c) {
        carrying = c;
    }

    public int getCarry() {
        return carrying;
    }
}
