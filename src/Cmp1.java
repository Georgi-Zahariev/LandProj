import java.util.Comparator;

public class Cmp1 implements Comparator<Owner> {

	@Override
	public int compare(Owner a, Owner b) {
		if( a.getArea() > b.getArea()) return -1;
		if( a.getArea() < b.getArea()) return 1;
		return a.familyName().compareTo(b.familyName());
	}

}
