package team.pfm.com;

public class Distance {
	
	public double statToNaut(double dis){
		double naut = dis*0.869;
		return naut;
	}
	public double statToKilom(double dis){
		double kilom = dis*1.61;
		return kilom;
	}
	public double statToStat(double dis){
		double stat = dis;
		return stat;
	}
	public double nautToKilom(double dis){
		double kilom = dis*1.852;
		return kilom;
	}
	public double nautToStat(double dis){
		double stat = dis*1.151;
		return stat;
	}
	public double nautToNaut(double dis){
		double naut = dis;
		return naut;
	}
	public double kilomToNaut(double dis){
		double naut = dis*0.54;
		return naut;
	}
	public double kilomToStat(double dis){
		double stat = dis*0.621;
		return stat;
	}
	public double kilomToKilom(double dis){
		double kilom = dis;
		return kilom;
	}
}
