package team.pfm.com;

public class Angles {
	private int deg;
	private int min;
	private int sec;
	public double dmsToRad(int deg, int min, int sec){
		double dec = dmsToDecDms(deg,min,sec);
		double rad = dec*2*Math.PI;
		return rad;
	}
	public double dmsToDms(double ang){
		double dms = ang;
		return dms;
	}
	public double radToRad(double ang){
		double rad = ang;
		return rad;
	}
	public double dmsToDecDms(int deg, int min, int sec){
		double dec = deg + (min/60) + (sec/3600);
		return dec;
	}
	public void decDmsToDms(double ang){
		deg = (int) (ang/1);
		double angmin = ang%1;
		min = (int) (angmin*60);
		double angsec = angmin%.1;
		sec = (int) (angsec*3600);
	}
	public int getDeg(){
		return (deg);
	}
	public int getMin(){
		return (min);
	}
	public int getSec(){
		return (sec);
	}
	
	public double radToDms(double ang){
		double decdms = ang/(2*Math.PI);
		decDmsToDms(decdms);
		
		return 0;
	}
}
