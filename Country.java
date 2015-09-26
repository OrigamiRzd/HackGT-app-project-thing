
public class Country {
	private String cName;
	private String fName;
	private Float pop;
	private double budget;
	
	public Country(){}
	
	public Country(String countryName,String faceName,Float population,double budget){
	this.cName = countryName;
	this.fName = faceName;
	this.pop = population;
	this.budget = budget;
	
	
	}
	
	public void Update(){
		
	}
	
	public void print(){
		String out = "Name: " +cName + "\nLeader: " + fName + "\nPopulation: " + pop + "\nBudget: " + budget;
		System.out.println(out);
	}

}
