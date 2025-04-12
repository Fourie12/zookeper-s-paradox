/**
 * Handle The enclosure information
 */

public class Enclosure {
	/* consists of enclousures for animals */

	/* but also store food storage depot info */
	/* if this  */
	boolean empty = false;

	int x;
	int y;
	int z;

	int importance = 0;

	int diet;

	public Enclosure() {
		/* empty by default */
		empty = true;
	}

	/**
	 * Create enclosure for food storage object
	 * @param x
	 * @param y
	 * @param z
	 * @param diet
	 */
	public Enclosure(int x1, int y1, int z1, int diet1) {
		x = x1;
		y = y1;
		z = z1;

		diet = diet1;
	}

	/**
	 * Enclosure for animals
	 * MAIN PURPOSE HERE
	 * @param z
	 * @param importance
	 */
	public Enclosure(int z1, int importance1) {
		z = z1;
		importance = importance1;
	}

	public int getImportance() {
		return importance;
	}

	public int getZ() {
		return z;
	}

	public getX() {
		return x;
	}

	public getY() {
		return Y;
	}
}