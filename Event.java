public class Event {
	private String dp;//description
	private Country c;

	public Event() {}

	public Event(String description,Country c) {
		this.dp = description;
		this.c = c;

	}
	
	public void setDes(String des){
		this.dp = des;
	}
	
	public void eventMessage(){
	    if (dp == "NATDISASTER") {
			    System.out.println("Oh no! A natural disaster has demolished your country!");
					float pop = c.getPop()*0.85f;
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
			    if(finalpop > 0){
			        c.setPop(finalpop);
			    }
			    else c.setPop(0f);
					double gdp = c.getGDP()*0.70f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
			    if(finalgdp > 0){
			        c.setGDP(finalgdp);
			    }
			    else c.setGDP(0f);
			}
			else if(dp == "EPIDEMIC") {
				  System.out.println("A harsh epidemic has resulted in several deaths along with a lower GDP");
					float pop = c.getPop()*0.6f;
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
					if(finalpop > 0){
							c.setPop(finalpop);
					}
					else c.setPop(0f);
					double gdp = c.getGDP()*0.3f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
					if(finalgdp > 0){
							c.setGDP(finalgdp);
					}
					else c.setGDP(0f);
			}
			else if(dp == "DROUGHT") {
          System.out.println("Sorry, a drought has led to the destruction of your crops");
					float pop = c.getPop()*0.9f;
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
					if(finalpop > 0){
							c.setPop(finalpop);
					}
					else c.setPop(0f);
					double gdp = c.getGDP()*0.70f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
					if(finalgdp > 0){
							c.setGDP(finalgdp);
					}
					else c.setGDP(0f);
			}
			else if(dp == "GOLDSTRUCK") {
				  System.out.println("Good News! A large gold mine has been found off the west coast!");
					float pop = c.getPop()*1.2f;
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
					if(finalpop > 0){
							c.setPop(finalpop);
					}
					else c.setPop(0f);
					double gdp = c.getGDP()*1.8f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
					if(finalgdp > 0){
							c.setGDP(finalgdp);
					}
					else c.setGDP(0f);
			}
			else if(dp == "OILFOUND") {
				  System.out.println("Congrats! There has been a large amount of oil discovered!");
					float pop = c.getPop()*1.1f;
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
					if(finalpop > 0){
							c.setPop(finalpop);
					}
					else c.setPop(0f);
					double gdp = c.getGDP()*1.9f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
					if(finalgdp > 0){
							c.setGDP(finalgdp);
					}
					else c.setGDP(0f);
			}
			else if(dp == "DISCOVERY") {
				  System.out.println("A new scientific discovery has been made, your GDP has significantly increased!");
					float pop = c.getPop();
					double newPop = Math.ceil(pop);
					float finalpop = (float) newPop;
					if(finalpop > 0){
							c.setPop(finalpop);
					}
					else c.setPop(0f);
					double gdp = c.getGDP()*2.1f;
					double newgdp = Math.ceil(gdp);
					float finalgdp = (float) newgdp;
					if(finalgdp > 0){
							c.setGDP(finalgdp);
					}
					else c.setGDP(0f);
			}
			else {
				  System.out.println("Welcome Back! Nothing of significance has happened");
			}
	    c.Update();
	    c.print();
		}

	}
