import java.util.Comparator;

public class Cmp2 implements Comparator<Owner>{

	@Override
	public int compare(Owner a, Owner b) {
		if( a.getNW().getY() > a.getNW().getY()) return -1;
		if( a.getNW().getY() < a.getNW().getY()) return 1;
		
		if( a.getNW().getX() > a.getNW().getX()) return 1;
		if( a.getNW().getX() < a.getNW().getX()) return -1;
		
	return 0;
	}
	

}
