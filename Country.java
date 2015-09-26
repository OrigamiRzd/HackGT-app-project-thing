import java.util.Random;

public class Country {
	private String cName;
	private String fName;
	private Float pop;
	private float popGrowthRate;
	private float budget;
	private float taxRate;
	private float gdp;
	private float gdpGrowthRate;
	private static int year;
	
	
	public Country(){}
	
	Random randOj = new Random();
	
	public Country(String countryName,String faceName,String pSize,float gdp){
	PopulationTrend pT = new PopulationTrend(pSize);
	this.gdpGrowthRate = randOj.nextFloat() * 20 - 10;
	this.popGrowthRate = (randOj.nextFloat() * 10 - 5)/100;
	this.cName = countryName;
	this.fName = faceName;
	this.pop = pT.popSize();
	this.budget = 0;
	this.taxRate = .01f;//[0 to .05]
	this.gdp = gdp;
	
	//this.gdpGrowthRate = gdpGRate;//[-.2 to .2] make a bell curve random pick thing
	year=0;
	}
	
	public float getBudget(){
		return this.budget;
	}
	
	public float getPerCapita(){
		return gdp/pop;
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
	
	public float getTaxRate(){
		return this.taxRate;
	}
	
	public void setGDPRate(float x){
		this.gdpGrowthRate = x;
	}
	
	public float getGDPRate(){
		return this.gdpGrowthRate;
	}
	
	public void setPop(float population){
		this.pop = population;
	}
	
	public float getPop(){
		return pop;
	}
	
	public void setPopRate(float pr){
		this.popGrowthRate = pr;
	}
	
	public int getYear(){
		return year;
	}
	
	public void Update(){
		
		this.gdpGrowthRate = randOj.nextFloat() * 20 - 10;
		System.out.println();
		budget = budget + (float)(this.gdp*taxRate);//Budget calc
		
		this.gdp = this.gdp - budget;
		this.gdp = this.gdp + this.gdp*(gdpGrowthRate/100);
        
        this.popGrowthRate = (randOj.nextFloat() * 10 - 5)/100;
        pop = pop + pop*popGrowthRate;
	
        System.out.println(gdpGrowthRate + "\n" +popGrowthRate);
		
	year++;
	}
	
	public void print(){
		String out = "Name: " +cName + "\nLeader: " + fName + "\nPopulation: " + pop + "\nBudget: " + budget + "\nGDP: " + gdp + "\nYear: " + year;
		System.out.println(out);
	}

}
