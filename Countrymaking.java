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
		System.out.println("\n1.small\n2.medium\n3.large\n4.colossal");
		String pSize = in.next();
		System.out.println(pSize +"\nGDP: ");
		float gdp = in.nextFloat();
		float gdpRate = 0;
		
		userCountry = new Country(name,lName,pSize,gdp,gdpRate);
		Event doAThing = new Event();
		RandomThing rT = new RandomThing();
		String des = "";
		while(true){
			double ran = rT.roll();
			if(ran > 50){
				des = "Nothing";
			}
			if(ran < 20){
				des = "ND";
			}
			doAThing = new Event(des,userCountry);
			System.out.println("put something");
			String c = in.next();
			
		}
	}

}
