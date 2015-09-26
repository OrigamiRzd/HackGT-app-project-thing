
public class Event {
	private String dp;//description
	
	public Event(String description) {
		this.dp = description;
		//Natural Disaster
		if (dp.equals("ND")){
			System.out.println("Natural Disaster! -not the game");
		}
		if(dp.equals("")){
			
		}
		//yearly report
		if(dp.equals("report")){
			System.out.println();
		}
	}
}
