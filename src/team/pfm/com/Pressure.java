package team.pfm.com;

public class Pressure {
	//converts milibars to mercury
	public double miliToMerc(double pre){
		double merc = pre *0.0295;
		return merc;
	}
	public double miliToMili(double pre){
		double mili = pre;
		return mili;
	}	
	//converts mercury to milibars
	public double mercToMili(double pre){
		double mili = pre * 33.864;
		return mili;
	}
	public double mercToMerc(double pre){
		double merc = pre;
		return merc;
	}
}
