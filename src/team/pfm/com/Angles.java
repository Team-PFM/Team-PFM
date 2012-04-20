package team.pfm.com;

public class Angles {	
	//converts degree minute second to radians by first converting dms to decimal form
	public double dmsToRad(double deg, double min, double sec){
		double dec = dmsToDecDms(deg,min,sec);
		double rad = dec*2*Math.PI;
		return rad;
	}
	//degree minute second to degree minute second
	public double dmsToDms(double ang){
		double dms = ang;
		return dms;
	}
	// radian to radian
	public double radToRad(double ang){
		double rad = ang;
		return rad;
	}
	//converts degree minute second to decimal form
	public double dmsToDecDms(double deg, double min, double sec){
		double dec = deg + (min/60) + (sec/3600);
		return dec;
	}
	//converts decimal form to degree minute second and returns an array with 
	//degree being the first minute second and second third in the array
	public double[] decDmsToDms(double ang){
		double[] dms;
		dms = new double[2];
		double degreer = (double) (ang%1);
		double mdouble = ang - degreer;
		double minr = (double) (mdouble%.1);
		double sect = ang - degreer - minr;
		dms[0] = (double) (ang/1);
		dms[1] = (double) ((mdouble/.1)*6);
		dms[2] = (double) ((sect/.01)*.6);
		return dms;
		}
	//
	public double radToDms(double ang){
		double decdms = ang/(2*Math.PI);
		decDmsToDms(decdms);
		return 0;
	}
}
