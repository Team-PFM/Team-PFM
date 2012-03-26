package team.pfm.com;

public class Pressure {
	public double miliToMerc(double pre){
		double merc = pre *0.0295;
		return merc;
	}
	public double miliToMili(double pre){
		double mili = pre;
		return mili;
	}	
	public double mercToMili(double pre){
		double mili = pre * 33.864;
		return mili;
	}
	public double mercToMerc(double pre){
		double merc = pre;
		return merc;
	}
}
