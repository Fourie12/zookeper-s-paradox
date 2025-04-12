import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ZooManager {

    public static Zoo zoo;
    public static int distance_capacity;
    public static Drone drone;

    public static void main(String[] args) {
        readFile();
        printFile();
    }

    private static void readFile() {
        try {

            // Zoo Coords
            Scanner scLine = new Scanner(new File("1.txt"));
            String[] z_coords = scLine.nextLine().split(",");
            zoo = new Zoo(Integer.parseInt(z_coords[0].replace("(", "")), Integer.parseInt(z_coords[1]),
                    Integer.parseInt(z_coords[2].replace(")", "")));

            // Depot Coords
            String[] depot_coords = scLine.nextLine().split(",");
            zoo.setDroneDepot(Integer.parseInt(depot_coords[0].replace("(", "")), Integer.parseInt(depot_coords[1]),
                    Integer.parseInt(depot_coords[2].replace(")", "")));

            // Distance Capacity
            distance_capacity = Integer.parseInt(scLine.nextLine());
            drone = new Drone(distance_capacity);

            // Food Storages Coords
            String food_storages_str = scLine.nextLine();
            food_storages_str = food_storages_str.substring(1, (food_storages_str.length() - 2));

            String[] food_storages = food_storages_str.split("\\),");

            for (int i = 0; i < food_storages.length; i++) {
                String[] temp_food = food_storages[i].split(",");
                int diet = 0;
                if (temp_food[3].equals("c")) {
                    diet = 1;
                } else if (temp_food[3].equals("o")) {
                    diet = 2;
                }
                zoo.setFoodCoord(Integer.parseInt(temp_food[0].replace("(", "")), Integer.parseInt(temp_food[1]),
                        Integer.parseInt(temp_food[2]), diet);
            }

            // Enclosures
            String enclosers_str = scLine.nextLine();
            enclosers_str = enclosers_str.substring(1, enclosers_str.length() - 2);

            String[] enclosures = enclosers_str.split("\\),");

            for (int i = 0; i < enclosures.length; i++) {
                String[] temp_encl = enclosures[i].split(",");

                int diet = 0;
                if (temp_encl[4].equals("c")) {
                    diet = 1;
                } else if (temp_encl[4].equals("o")) {
                    diet = 2;
                }

                zoo.setEnclosureCoord(Integer.parseInt(temp_encl[0].replace("(", "")), Integer.parseInt(temp_encl[1]),
                        Integer.parseInt(temp_encl[2]), Float.parseFloat(temp_encl[3]), diet);
            }

            // System.out.println(zoo);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void printFile() {
        String output = "[";
        //String[][] dests = null;
        String[][] dests = {{"8,10","6,9","8,10"},{"8,10","5,5","8,10"}};

        for (int i = 0; i < dests.length; i++) {
            output += "[";
            for (int j = 0; j < dests[i].length; j++) {
                output += "(" + dests[i][j] + ")";
                if ((j + 1) != dests[i].length) {
                    output += ",";
                }
            }
            output += "]";
            if ((i + 1) != dests.length) {
                output += ",";
            }

            

        }
        output+="]";
        
        try {
            FileWriter outFile = new FileWriter("out.txt");
            outFile.write(output);
            outFile.close();
        } catch (IOException e) {
            System.out.println("File not Found");
        }

    }

    // /*
    // * Feeds ONE enclosure
    // */
    // public void feed_enclosure(int x, int y, int d) {

    // switch (d) {
    // case HERBI:
    // herbis[x][y].setEmpty();
    // pri_herbis[x][y] = 0;
    // num_herbis_fed++;
    // break;

    // case CARNI:
    // carnis[x][y].setEmpty();
    // pri_carnis[x][y] = 0;
    // num_carnis_fed++;
    // break;

    // case OMNI:
    // omnis[x][y].setEmpty();
    // pri_omnis[x][y] = 0;
    // num_omnis_fed++;
    // break;

    // default:
    // break;
    // }

    // num_animals_fed++;

    // }
}