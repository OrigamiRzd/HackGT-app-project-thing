
public class Event {
	private String dp;//description
	
	public Event() {}
	
	public Event(String description, Country c) {
		this.dp = description;
		//Natural Disaster
		if (dp.equals("ND")){
			System.out.println("Natural Disaster! -not the game");
			//population and gdp get effected negatively
			float pop = c.getPop() - 10000f;
			if(pop>0){
			c.setPop(pop);
			}
			else c.setPop(0f);
		}
		if(dp.equals("Win")){
			System.out.println("Something good happens!");
			//GDP increases or gdp growth rate increases
			//or something
		}
		if(dp.equals("Nothing"))
		//yearly report
		if(dp.equals("report")){
			c.Update();
			c.print();
		}
	}
}
