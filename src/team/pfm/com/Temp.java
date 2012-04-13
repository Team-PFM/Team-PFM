package team.pfm.com;

public class Temp {
	//conversion class for temperature.
	public double celToFah(double tem){
		double fah = (5/9)*(tem - 32);
		return fah;
	}
	public double celToKev(double tem){
		double kev = tem+273.15;
		return kev;
	}
	public double celToRan(double tem){
		double ran = tem*(9/5)+32+459.67;
		return ran;
	}
	public double celToCel(double tem){
		double cel = tem;
		return cel;
	}
	public double fahToCel(double tem){
		double cel = (9/5)*tem + 32;
		return cel;
	}
	public double fahToKev(double tem){
		double kev = (9/5)* tem + 305.15;
		return kev;
	}
	public double fahToRan(double tem){
		double ran = tem+459.67;
		return ran;
	}
	public double fahToFah(double tem){
		double fah = tem;
		return fah;
	}
	public double kevToCel(double tem){
		double cel = tem - 273.15;
		return cel;
	}
	public double kevToFah(double tem){
		double fah = (5/9)*(tem - 305.15);
		return fah;
	}
	public double kevToRan(double tem){
		double ran = tem*(9/5);
		return ran;
	}
	public double kevToKev(double tem){
		double kev = tem;
		return kev;
	}
	public double ranToCel(double tem){
		double cel = (tem-32-459.67)/(9/5);
		return cel;
	}
	public double ranToFah(double tem){
		double fah = tem-459.67;
		return fah;
	}
	public double ranToKev(double tem){
		double kev = tem/(9/5);
		return kev;
	}
	public double ranToRan(double tem){
		double ran = tem;
		return ran;
	}

}
