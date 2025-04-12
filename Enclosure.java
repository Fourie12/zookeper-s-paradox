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

	float importance = 0;

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
	public Enclosure(int z1, float importance1) {
		z = z1;
		importance = importance1;
	}

	public float getImportance() {
		return importance;
	}

	public int getZ() {
		return z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isEmpty() {
		return empty;
	}

	public int getDiet() {
		return diet;
	}

	public String toString() {
		String temp = " Enclosure toString: \n";

		temp += " is empty: " + isEmpty();
		temp += " x: " + getX();
		temp += " y: " + getY();

		temp += " importance: " + getImportance();

		temp += " diet: " + getDiet();

		temp += "\n\n";

		return temp;
	}
}