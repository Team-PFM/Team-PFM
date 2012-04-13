package team.pfm.com;

public class Distance {
	//converts statue miles to nautical miles
	public double statToNaut(double dis){
		double naut = dis*0.869;
		return naut;
	}
	//converts statue miles to kilometers
	public double statToKilom(double dis){
		double kilom = dis*1.61;
		return kilom;
	}
	//converts statue miles to statue miles
	public double statToStat(double dis){
		double stat = dis;
		return stat;
	}
	//converts nautical miles to kilometers
	public double nautToKilom(double dis){
		double kilom = dis*1.852;
		return kilom;
	}
	//converts nautical to statue miles
	public double nautToStat(double dis){
		double stat = dis*1.151;
		return stat;
	}
	//converts nautical miles to nautical miles
	public double nautToNaut(double dis){
		double naut = dis;
		return naut;
	}
	//converts kilometer to nautical miles
	public double kilomToNaut(double dis){
		double naut = dis*0.54;
		return naut;
	}
	//converts kilometer to statue miles
	public double kilomToStat(double dis){
		double stat = dis*0.621;
		return stat;
	}
	//converts kilometer to kilometer
	public double kilomToKilom(double dis){
		double kilom = dis;
		return kilom;
	}
}
