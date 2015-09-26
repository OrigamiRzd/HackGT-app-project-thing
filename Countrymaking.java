import java.util.Scanner;
public class Countrymaking {

	public static void main(String[] args) {
		Country userCountry = new Country();
		Scanner in = new Scanner(System.in);
		System.out.println("Name: ");
		String name = in.next();
		System.out.println("Leader Name: ");
		String lName = in.next();
		System.out.println("Population: ");
		Float pop = in.nextFloat();
		System.out.println("GDP: ");
		double gdp = in.nextDouble();
		double gdpRate = 0;
		
		userCountry = new Country(name,lName,pop,gdp,gdpRate);
		Event doAThing = new Event();
		
		while(true){
			doAThing
		}
	}

}
