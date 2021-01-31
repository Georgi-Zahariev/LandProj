
public class Rect {
	private Point NW;
	private Point SE;

	public Rect() {
		NW = null;
		SE = null;
	}

	public Point getNW() {
		return NW;
	}

	public void setNW(int a, int b) {
		NW = new Point(a, b);
	}

	public Point getSE() {
		return SE;
	}

	public void setSE(int a, int b) {
		SE = new Point(a, b);
	}

	public long getBorder(long a, long b) {
		if (a == b)
			return 0;
		if (a < b) {
			long t = a;
			a = b;
			b = t;
		}
		return a - b;
	}

	public long getArea() {
		return (getBorder((long) NW.getX(), (long) SE.getX())) * (getBorder((long) NW.getY(), (long) SE.getY()));

	}

	public Rect intersect(Rect r) {
		if(SE.getX() <= r.getNW().getX() ) return null;
		if (NW.getX() >= r.getSE().getX() ) return null;
		if ( NW.getY() <= r.getSE().getY() ) return null;
		if( SE.getY() >=r.getNW().getY() )return null;
		
		Rect d = new Rect();
		d.setNW(Integer.max(NW.getX(), r.NW.getX()), Integer.min(NW.getY(), r.NW.getY()));
		d.setSE(Integer.min(NW.getX(), r.NW.getX()), Integer.max(NW.getY(), r.NW.getY()));
		
		return d;

	}

	public String toString() {
		return NW.toString() + " " +SE.toString();
	}

}
