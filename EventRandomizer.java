
public class EventRandomizer {

	public EventRandomizer() {}
	
	public String random(){
		RandomThing random = new RandomThing();
		double x =  random.roll();
		String description = "";
		if(x > 89){
			description = "NATDISASTER";
		}
		else if(x > 79 && x<=89 ){
			description ="EPIDEMIC";
		}
		else if(x > 69 && x<=79){
			description ="DROUGHT";
		}
		else if(x > 59 && x<=69){
			description ="GOLDSTRUCK";
		}
		else if(x > 49 && x<=39){
			description ="OILFOUND";
		}
		else if(x > 29 && x<=39){
			description ="DISCOVERY";
		}
		return description;
	}
	
}
