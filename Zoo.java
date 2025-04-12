/**
 * Handle the 2D array holding the enclosure information -
 * the grid
 */
public class Zoo {
	/* have three different 2D matrices */

	final int HERBI = 0;
	final int CARNI = 1;
	final int OMNI = 2;

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
	public void setFoodCoord(int x, int y, int z, final int diet) {
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
	public void setEnclosureCoord(int x, int y, int z, int importance, final int diet) {
		Enclosure new_enc = new Enclosure(z, importance);
		switch(diet) {
			case(HERBI):
				herbis[x][y] = new_enc;
				break;
			case(CARNI):
				carnis[x][y] = new_enc;
				break;
			case(OMNI):
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
}