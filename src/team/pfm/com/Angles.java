package team.pfm.com;

public class Angles {	
	//converts degree minute second to radians by first converting dms to decimal form
	public double dmsToRad(double deg, double min, double sec){
		double dec = dmsToDecDms(deg,min,sec);
		double rad = dec*(Math.PI/180);
		return rad;
	}
	//degree minute second to degree minute second
	public int[] dmsToDms(int ang, int min, int second){
		int[] dms = new int[3];
		dms[0] = ang;
		dms[1] = min;
		dms[2] = second;
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
	public int[] decDmsToDms(double ang){
		int[] dms;
		dms = new int[3];
		double degr = ang%1;
		double min = degr*60;
		double minr = min%1;
		double sec = minr * 60;
		double secr = sec%1;
		dms[0] = (int) (ang - degr);
		dms[1] = (int) (min - minr);
		dms[2] = (int) (sec - secr);
		return dms;
		}
	//
	public int[] radToDms(double ang){
		double decdms = ang*(180/Math.PI);
		int[] dms = new int[3];
		dms = decDmsToDms(decdms);	
		return dms;
	}
}
