import java.util.Random;

public class Country {
	private String cName;
	private String fName;
	private Float pop;
	private float budget;
	private float taxRate;
	private float gdp;
	private float gdpGrowthRate;
	private static int year;
	
	public Country(){}
	
	Random randOj = new Random();
	
	public Country(String countryName,String faceName,String pSize,float gdp, float gdpGRate){
	PopulationTrend pT = new PopulationTrend(pSize);
	this.cName = countryName;
	this.fName = faceName;
	this.pop = pT.popSize();
	this.budget = 0;
	this.taxRate = .01f;//[0 to .05]
	this.gdp = gdp;
	this.gdpGrowthRate = gdpGRate;//[-.2 to .2] make a bell curve random pick thing
	year=0;
	}
	
	public void setGDP(float x){
		this.gdp = x;
	}
	
	public float getGDP(){
		return this.gdp;
	}
	
	public void setTaxRate(float x){
		this.taxRate = x;
	}
	
	public double getTaxRate(){
		return this.taxRate;
	}
	
	public void setGDPRate(float x){
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
	
	public int getYear(){
		return year;
	}
	
	public void Update(){
		
		float growthRate = randOj.nextFloat() * 20 - 10;
		System.out.println();
		budget = budget + this.gdp*taxRate;//Budget calc
		
		this.gdp = this.gdp - budget;
		this.gdp = this.gdp + this.gdp*(growthRate/100);
        
        float popGrowth = randOj.nextFloat() * 10 - 5;
        float popRate = popGrowth/100;
        pop = pop + pop*popRate;
	
        System.out.println(growthRate + "\n" +popGrowth);
		
	year++;
	}
	
	public void print(){
		String out = "Name: " +cName + "\nLeader: " + fName + "\nPopulation: " + pop + "\nBudget: " + budget + "\nGDP: " + gdp + "\nYear: " + year;
		System.out.println(out);
		System.out.println(this.pop.SIZE);
	}

}
