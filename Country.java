
public class Country {
	private String cName;
	private String fName;
	private Float pop;
	private double budget;
	private double taxRate;
	private double gdp;
	private double gdpRate;
	private static int x;
	
	public Country(){}
	
	public Country(String countryName,String faceName,Float population,double gdp){
	this.cName = countryName;
	this.fName = faceName;
	this.pop = population;
	this.budget = 0;
	this.taxRate = .1;
	this.gdp = gdp;
	this.gdpRate = .1;
	x=0;
	}
	
	public void Update(){
	this.gdp = (1+gdpRate)*gdp;
	this.budget = taxRate*this.gdp + budget;
	
	this.gdp = gdp-budget;
	x++;
	}
	
	public void print(){
		String out = "Name: " +cName + "\nLeader: " + fName + "\nPopulation: " + pop + "\nBudget: " + budget + "\nGDP: " + gdp + "\nYear: " + x;
		System.out.println(out);
	}

}
