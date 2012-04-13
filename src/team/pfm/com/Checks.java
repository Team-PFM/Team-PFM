package team.pfm.com;

public class Checks {
	//this class is used to check the varibles inputed by the user
	//to see if the varibles arevalid inputs
	//checks to see if any value inputed into this method is positive
	public boolean isPosValid(double val){
		if (val >= 0){
			return true;
		}else{
			return false;
		}
	}
	//checks to see if radian is a valid input
	public boolean isRadValid(double rad){
		if (rad >= 0 && rad<=(Math.PI*2)){
			return true;
		}else{
			return false;
		}
	}
	//checks to see if degree is a valid input
	public boolean isDegValid(int deg){
		if(deg <= 360 && deg >= 0){
			return true;
		}else{
			return false;
		}
	}
	//checks to see if deg min and sec are vaild inputs
	public boolean isDegMinSecValid(int deg,int min, int sec){
		if(deg == 360 && min ==0 && sec == 0){
			return true;
		}else if (deg >=0 && deg <360 && min >= 0 && min<60 && sec >= 0 && sec<60){
			return true;
		}else{
			return false;
		}
	}
	//checks to see if the temp is valid
	public boolean isTempValid(double temp){
		if (temp >= -50 && temp<150){
			return true;
		}else{
			return false;
		}
		
	}
	// checks to see if lat and long are valid inputs.
	public boolean isLatLongValid(double lat, double lon){
		if (lat >= 0 && lat<360){
			if (lon >0 && lat<180){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
