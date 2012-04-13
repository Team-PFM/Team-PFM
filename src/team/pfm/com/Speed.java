package team.pfm.com;

public class Speed {
	//miles per hour to knots
	public double mphToKnots(double spe){
		double knots = spe*0.87;
		return knots;
	}
	//miles per hour to kilometers per hour
	public double mphToKmh(double spe){
		double kmh = spe*1.609;
		return kmh;
	}
	
	public double mphToMph(double spe){
		double mph = spe;
		return mph;
	}
	//knots to miles per hour
	public double knotsToMPH(double spe){
		double mph = spe*1.15;
		return mph;
	}
	//knots to kilometers per hour
	public double knotsToKmh(double spe){
		double kmh = spe*1.852;
		return kmh;
	}
	
	public double knotsToKnots(double spe){
		double knots = spe;
		return knots;
	}
	//kilometer per hour to miles per hour
	public double kmhToMph(double spe){
		double mph = spe*0.621;
		return mph;
	}
	//kilometer per hour to knots
	public double kmhToKnots(double spe){
		double knots = spe*0.54;
		return knots;
	}
	
	public double kmhToKmh(double spe){
		double kmh = spe;
		return kmh;
	}
	

}
