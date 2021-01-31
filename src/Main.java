import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static final boolean stdInput = true; // Дали входът е от стандартния вход
	private static ArrayList<Owner> data = new ArrayList<Owner>();

	private static boolean isConflicting(int n) {
		for (int i = 0; i < data.size(); i++) {
			if (i != n) {
				if ((data.get(i)).intersect(data.get(n)) != null)
					return true;
			}
		}
		return false;
	}

	public static long commonArea() {
		long s = 0;
		int minx = 1000;
		int miny = 1000;
		int maxx = 0;
		int maxy = 0;

		for (Owner owner : data) {
			if (owner.getNW().getX() < minx)
				minx = owner.getNW().getX();
			if (owner.getNW().getY() < miny)
				miny = owner.getNW().getY();
			if (owner.getSE().getX() < maxx)
				maxx = owner.getSE().getX();
			if (owner.getSE().getY() < minx)
				maxy = owner.getSE().getX();
		}

		for (int x = minx; x < maxx; x++)
			for (int y = maxy; y < miny; y++) {
				Rect r = new Rect();
				r.setNW(x, y);
				r.setSE(x + 1, y - 1);
				for (int i = 0; i < data.size(); i++) { // proverka za prinadlejnost
					if (r.intersect(data.get(i)) != null) {
						s++;
						break;
					}

				}
			}
		return s;

	}

	public static void input() {
		Scanner inp = null;
		File f = null;
		if (stdInput)
			inp = new Scanner(System.in);
		else
			f = new File("Data.txt");
		try {
			if (!stdInput)
				inp = new Scanner(f);// Подсказки само ако входът е System.in
			if (stdInput)
				System.out.print("Брой собственици: ");
			int n = inp.nextInt();
			inp.nextLine();// Зачистване на входния буфер!
			for (int i = 0; i < n; i++) {
				if (stdInput)
					System.out.println("Данни за собственик No " + (i + 1));
				Owner owner = new Owner(inp, stdInput);// Създаване на собственик от поток inp
				data.add(owner);// Добавяне към динамичния масив
			}
			inp.close();
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(0);// Изход от процеса
		}
	}

	

	public static void list1() {// Първи списък
		data.sort(new Cmp1());// Сортиране по критериите
		for (int i = 0; i < data.size(); i++) {// Извеждане на списъка
			if (i < 10)
				System.out.print(' ');
			if (i < 100)
				System.out.print(' ');
			System.out.println((i + 1) + ". " + data.get(i).getName() + ": " + data.get(i).getArea());
		}
	}

	public static void list2() {// Втори списък
		data.sort(new Cmp2());// Сортиране по критериите
		for (int i = 0, j = 1; i < data.size(); i++)
			if (!isConflicting(i)) { // Филтриране и
										// извеждане на списъка
				if (i < 10)
					System.out.print(' ');
				if (i < 100)
					System.out.print(' ');
				System.out.println(j++ + ". " + data.get(i).personalName() + " " + data.get(i).familyName() + " "
						+ data.get(i).toString());
			}
	}

	public static void main(String[] args) {
		//повикване на метод за всяка подзадача
		input();
		System.out.println();
		list1();
		System.out.println();
		list2();
		System.out.println();
		System.out.println( "Common area is: " + commonArea());
	}

}
