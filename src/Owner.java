import java.util.Scanner;

public class Owner extends Rect implements NameTools {
	private String name;

	public Owner(Scanner a, boolean stdInput) {

		// Подсаказки -само ако е от стандартния вход
		if (stdInput)
			System.out.print("Име и презиме: ");

		name = a.nextLine(); // Предполагаме, че входният буфер е чист!

		System.out.println(" North-West corner ");
		System.out.print("X: ");
		int x = a.nextInt();
		System.out.print("Y: ");
		int y = a.nextInt();

		setNW(x, y);

		System.out.println(" South-East corner ");
		System.out.print("X: ");
		x = a.nextInt();
		System.out.print("Y: ");
		y = a.nextInt();

		setSE(x, y);

		a.nextLine();

	}

	public String getName() {
		return name;
	}

	@Override
	public String personalName() {
		return name.substring(0, name.indexOf(' '));

	}

	@Override
	public String familyName() {

		return name.substring(name.indexOf(' ') + 1, name.length());
	}

}
