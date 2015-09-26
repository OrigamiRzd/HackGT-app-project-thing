
public class Country {
	private String cName;
	private String fName;
	private Float pop;
	private double budget;
	private double taxRate;
	private double gdp;
	private double gdpGrowthRate;
	private static int x;
	
	public Country(){}
	
	public Country(String countryName,String faceName,Float population,double gdp, double gdpGRate){
	this.cName = countryName;
	this.fName = faceName;
	this.pop = population;
	this.budget = 0;
	this.taxRate = .1;//[0 to .2]
	this.gdp = gdp;
	this.gdpGrowthRate = gdpGRate;//[-.2 to .2] make a bell curve random pick thing
	x=0;
	}
	
	public void setTaxRate(double x){
		this.taxRate = x;
	}
	
	public double getTaxRate(){
		return this.taxRate;
	}
	
	public void setGDPRate(double x){
		this.gdpGrowthRate = x;
	}
	
	public double getGDPRate(){
		return this.gdpGrowthRate;
	}
	
	public void setPop(Float population){
		this.pop = population;
	}
	
	public Float getPop(){
		return pop;
	}
	
	public void Update(){
	this.gdp = (1+gdpGrowthRate)*gdp;
	this.budget = taxRate*this.gdp + budget;
	
	this.gdp = gdp-budget;
	x++;
	}
	
	public void print(){
		String out = "Name: " +cName + "\nLeader: " + fName + "\nPopulation: " + pop + "\nBudget: " + budget + "\nGDP: " + gdp + "\nYear: " + x;
		System.out.println(out);
	}

}
