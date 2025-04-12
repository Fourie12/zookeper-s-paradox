



/**
 * Handle the 2D array holding the enclosure information -
 * the grid
 */
public class Zoo {
	/* have three different 2D matrices */

	final int HERBI = 0;
	final int CARNI = 1;
	final int OMNI = 2;

	int num_animals = 0;
	int num_animals_fed = 0;

	int num_omnis = 0;
	int num_herbis = 0;
	int num_carnis = 0;

	int num_omnis_fed = 0;
	int num_herbis_fed = 0;
	int num_carnis_fed = 0;


	int zoo_x;
	int zoo_y;
	int zoo_z;

	Enclosure herbis [][];
	Enclosure carnis [][];
	Enclosure omnis [][];

	Enclosure food_depots[] = new Enclosure[3];

	int [][] pri_herbis;
	int [][] pri_carnis;
	int [][] pri_omnis;
	
	int drone_x;
	int drone_y;
	int drone_z;

	int x_last;
	int y_last;

	static int iter = 0;

	public Zoo(int x, int y, int z) {
		/* store zoo coordinates */
		zoo_x = x;
		zoo_y = y;
		zoo_z = z;

		herbis = new Enclosure[x][y];
		omnis = new Enclosure[x][y];
		carnis = new Enclosure[x][y];

		pri_carnis = new int[x][y];
		pri_herbis = new int[x][y];
		pri_omnis = new int[x][y];


		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				pri_carnis[i][j] = 0;
				pri_herbis[i][j] = 0;
				pri_omnis[i][j] = 0;
			}
		}
	}

	/**
	 * Drone Depot Coords
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setDroneDepot(int x, int y, int z) {
		drone_x = x;
		drone_y = y;
		drone_z = z;
	}

	/**
	 * Store details of ONE food STORAGE DEPOT
	 * @param x
	 * @param y
	 * @param z
	 * @param diet
	 */
	public void setFoodCoord(int x, int y, int z, int diet) {
		Enclosure food_enclosure = new Enclosure(x, y, z, diet);
		food_depots[iter] = food_enclosure;
		iter++;
	}

	/**
	 * Store details for one enclosure
	 * @param x
	 * @param y
	 * @param z
	 * @param importance
	 * @param diet
	 */
	public void setEnclosureCoord(int x, int y, int z, float importance, int diet) {
		num_animals++;
		Enclosure new_enc = new Enclosure(z, importance);
		switch(diet) {
			case(HERBI):
				num_herbis++;
				herbis[x][y] = new_enc;
				break;
			case(CARNI):
				num_carnis++;
				carnis[x][y] = new_enc;
				break;
			case(OMNI):
				num_omnis++;
				omnis[x][y] = new_enc;
				break;
		}
	}

	/**
	 * Store details of ONE dedad zone
	 * @param x
	 * @param y
	 * @param r
	 */

	public void setDeadZone(int x, int y, int r) {

	}

    @Override
	public String toString() {

		String temp = "******************FOR ENCLOSURES***********************\n";
		temp += "zoo_x: " + zoo_x + " zoo_y: " + zoo_y + "\n";
		String pri = "\n******************FOR PRIORITY MATRIX***********************\n";
		String food = "\n******************FOR FOOD DEPOT***********************\n";
		for (int i = 0; i < zoo_x; i++) {
			temp += "\n";
			for (int j = 0; j < zoo_y; j++) {

				temp += "\tX: " + i;
				temp += "\tY: " + j;
				
				/* herbis */
				//temp += "##Herbivores##";
				//pri += "##Herbivores##";
				//food += "##Herbivores##";
				/*enclosures */
				try {
					temp += herbis[i][j].toString();
				} catch (NullPointerException e) {
					temp += " NULL ";
				}
				
				/*priorities */
				try{
					pri += " " + pri_herbis[i][j];
				} catch (NullPointerException e) {
					pri += " NULL ";
				}

				/* carnis */
				//temp += "##Carnivores##";
				//pri += "##Carnivores##";
				//food += "##Carnivores##";
				/*enclosures */
				try {
					temp += carnis[i][j].toString();
				} catch (NullPointerException e) {
					temp += " NULL ";
				}
				/*priorities */
				try {
					pri += " " + pri_carnis[i][j];
				} catch (NullPointerException e) {
					pri += " NULL ";
				}

				/* omnis */
				//temp += "\n\n##Omnivores##\n\n";
				//pri += "\n\n##Omnivores##\n\n";
				//food += "\n\n##Omnivores##\n\n";
				/*enclosures */
				try {
					temp += omnis[i][j].toString();
				} catch (NullPointerException e) {
					temp += " NULL ";
				}
				
				/*priorities */
				try {
					pri += " " + pri_omnis[i][j];
				} catch (NullPointerException e) {
					pri += " NULL";
				}
				
			}

			
		}

		/* food depots */
		for (int j = 0; j < iter; j++) {
			food += food_depots[j];
		}


		//temp += pri + food + "*****************************************\n";
		temp += food + "*****************************************\n";

		temp += "\nnum_animals: " + num_animals;
		temp += "\nnum_animals_fed: " + num_animals_fed;

		temp += "\nnum_carnis: " + num_carnis;
		temp += "\nnum_herbis: " + num_herbis;
		temp += "\nnum_omnis: " + num_omnis;

		temp += "\n*************************DONE*****************************";
		
		return temp;
	}

	public double getDist(int x1, int y1, int x2, int y2, int z2) {
		double dist = 0.0;

		dist = Math.sqrt((Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2)));

		dist += (50 - z2)*2;

		return dist;
	}

	public double getPoints(double importance, double dist) {
		return (1000*importance) - dist;
	}

	/*
    * Feeds ONE enclosure
    */
    public void feed_enclosure(int x, int y, int d) {

		switch (d) {
			case HERBI:
				herbis[x][y].setEmpty();
				pri_herbis[x][y] = 0;
				num_herbis_fed++;
			break;
		
			case CARNI:
				carnis[x][y].setEmpty();
				pri_carnis[x][y] = 0;
				num_carnis_fed++;
			break;
		
			case OMNI:
				omnis[x][y].setEmpty();
				pri_omnis[x][y] = 0;
				num_omnis_fed++;
			break;
		
			default:
				break;
			}
		
			num_animals_fed++;
	
		}

	public String feedAll() {
		String temp = "[";

		x_last = drone_x;
		y_last = drone_y;

		Enclosure[][] cur_enclosure = new Enclosure[zoo_x][zoo_y];

		double dist = 0;

		double shortest_dist = 9999999;
		Enclosure shortestEnc = new Enclosure();
		Enclosure enc;

		/* calculate which food depot to go to */

		for (int i = 0; i < 3; i++) {
			enc = food_depots[i];
			dist = getDist(x_last, y_last, enc.getX(), enc.getY(), enc.getZ());

			if (dist < shortest_dist) {
				shortest_dist = dist;
				shortestEnc = enc;
			}
		}

		switch (shortestEnc.getDiet()) {
			case(HERBI) :
				//pri_curr_feed = Arrays.(pri_herbis);
				//copy cur enclosure too
				break;
			case(CARNI) :
				break;
			case(OMNI) :
				break;
		}

		while(num_animals_fed < num_animals) {
			int [] arr = new int[2];
			arr = get_next_coords(cur_enclosure);

			//TODO reset last fed

			feed_enclosure(x_last, y_last, cur_enclosure[arr[0]][arr[1]].getDiet());
	
		}


		return temp + "]";
	}

	public int[] get_next_coords(Enclosure[][] cur_enclosure) {

		int cur_highest_points = 0;
		double dist = 0;
		double points = 0;

		int possible_next_x = 0;
		int possible_next_y = 0;

		for (int i = 0; i < zoo_x; i++) {
			for (int j = 0; j < zoo_y; j++) {
				
				if (cur_enclosure[i][j].getImportance() > 0) {
					dist = getDist(x_last, y_last, i, j, cur_enclosure[i][j].getZ());
					points = getPoints(cur_enclosure[i][j].getImportance(), dist);

					if (points > cur_highest_points) {
						possible_next_x = i;
						possible_next_y = j;
					}
				}	
			}
		}

		int[] arr = new int[2];
		arr[0] = possible_next_x;
		arr[1] = possible_next_y;

		return arr;
	}
}