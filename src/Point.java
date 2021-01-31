
public class Point {
	private int x;
	private int y;

	public Point(int abs, int orb) {
		x = abs;
		y = orb;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "( " + x + ", " + y + " )";
	}

}
