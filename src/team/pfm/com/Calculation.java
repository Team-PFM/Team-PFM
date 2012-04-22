package team.pfm.com;
/*Calculations Class
 * All calculations besides unit conversions are done through this class for the FPC application.
 * Proprietary document of Team PFM
 * Created by Michael Kouremetis
 */


public class Calculation {
// Calculation methods
	
	//calculates true airspeed given above sea level altitude and indicated airspeed
	//THIS NEEDS TO BE LOOKED AT, DONT KNOW IF RIGHT FORMULA
	public static double calcTrueAsp(double altitude, double indAirSpeed){
			double ias2 = (indAirSpeed) * .02;
			double msl2 = Math.floor(altitude / 1000);
			return Math.round((ias2 * msl2) + (indAirSpeed));
		
	}
	
	//calculate density altitude given outside air temperature(in celsius) and and pressure altitude
	public static double calcDensAlt(double temp, double presAlt){
		double t_k = 273.15 + temp;
		double  t_s = 273.15 + (15 - (.0019812 * presAlt));
		double d_Alt = presAlt + (t_s/.0019812) * (1 - (Math.pow(t_s/t_k, .2349690)));
		
		return Math.round(d_Alt);
	}


	//Calculates head wind and cross wind given wind speed wind direction and runway direction
	// returns 4 values as an array that denote speed and direction of winds
	//0deg is due north, 180deg is due south, 90deg is east, 270deg is due west
	public static double[] calcRunWinds(double windSpe,double windDir, double runwayDir){
		double xwindDir;
		double hwindDir;
		double []val = new double[4];
		double angle = Math.abs(windDir - runwayDir);
		//determines what direction the xwind is coming from
		if(windDir> runwayDir && windDir<(runwayDir + 180) ){
			xwindDir = 1;//VALUE 1 DENOTES XWIND COMING FROM THE RIGHT
		}
		else{
			xwindDir = 2;//VALUE 1 DENOTES XWIND COMING FROM THE LEFT
		}
		//determines if the headwind is for or against
		if(windDir>(runwayDir + 90) && windDir<(runwayDir +270)){
			hwindDir = 1; //VALUE 1 DENOTES A HEADWIND THAT IS FOR OR TECHNICALLY IS A TAILWIND
		}
		else{
			hwindDir = 2;//VALUE 2 DENOTES A TRU HEADWIND THAT IS WORKING AGAINST
			
		}
		val[0] = Math.abs(Math.sin(Math.toRadians(angle)) * windSpe); //this is the cross wind value in array[1] spot
		val[1] = Math.abs(Math.cos(Math.toRadians(angle)) * windSpe); //this is the head wind value in array[2] spot
		val[2] = xwindDir;//xwind direction value in array[3] spot
		val[3]= hwindDir;//hwind direction value in array[4] spot
		return val ;
	}
	
	 //calculates wind speed given ground speed, true air speed, course and heading
	//the calculation was configured using a system of equations 
	public static double calcWindSpe(double groSpe, double trueAir, double course , double heading){
		double wca = heading - course;
		double windSpe= Math.sqrt( Math.pow(groSpe, 2) + Math.pow(trueAir,2) -(2*groSpe* trueAir * Math.cos(Math.toRadians(wca))));
		return windSpe;
	}
	
	//calculates wind directions given ground speed, true air speed, course and heading
	//the calculation was configured using a system of equations 
	//all data is input as radians
	public static double calcWindDir(double groSpe, double trueAir, double course , double heading){
		double ws = calcWindSpe(groSpe, trueAir, course, heading);
		double wca = heading - course;
		
		return heading + Math.toDegrees(Math.asin((groSpe/ws) * Math.sin(Math.toRadians(wca)) ));
		
		 
	}
	
	//calculates the wind correction angle given wind speed, wind direction(from source), airspeed, and course
	public static double calcCorAng(double windSpe, double windDir, double trueAir, double course){
		double windDirDownwind = windDir + 180; //getting the downwind direction of the wind
		if(windDirDownwind>=360){
			windDirDownwind= windDirDownwind - 360;
		}
		 
		double wtangle = course - windDirDownwind;
		
		return Math.toDegrees(Math.asin((windSpe/trueAir) * Math.sin(Math.toRadians(wtangle))));	
	}
	
	//calculates the ground speed given wind speed, wind direction, air speed, and course
	public static double calcGroSpeed(double windSpe, double windDir,double course, double trueAir){
		double dwdir = windDir + 180;
		if(dwdir>=360){
			dwdir= dwdir - 360;
		}
		
		double wca = calcCorAng(windSpe, windDir, trueAir, course);
		return (trueAir * Math.cos(Math.toRadians(wca))) + (windSpe * Math.cos(Math.toRadians(course - dwdir)));
	}
	
	//calculates the heading given wind speed, wind direction, air speed, and course
	public static double calcHead(double windSpe, double windDir, double course, double trueAir){
		double wca = calcCorAng(windSpe, windDir, trueAir, course);
		return wca + course;
	}
	
	//calculates flying distance between the two airports that are given through ID's
	//values from database class methods must be in radians as this is what is used here
	public static double calcFlyDis(String id1, String id2){
		double r = 6371; //this is KM which means the distance is returned in KM
		double cord1[] = FPCDatabase.accsAir(id1);
		double cord2[]= FPCDatabase.accsAir(id2);
		double lat1 = Math.toRadians(cord1[0]);
		double lat2 = Math.toRadians(cord2[0]);
		double latD = lat2 -lat1;
		double longD = Math.toRadians(cord2[1] - cord1[1]); //longD is the difference of longitude 2 - longitude 1
		double a = Math.sin(latD/2) * Math.sin(latD/2) +
	        Math.sin(longD/2) * Math.sin(longD/2) * Math.cos(lat1) * Math.cos(lat2);
		
		return r * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
	}
	
	//calculates initial course between two airports given through airport ID's
	//values from database class methods must be in radians as this is what is used here
	public static double calcCourBwAir(String id1, String id2){
		double cord1[] = FPCDatabase.accsAir(id1);
		double cord2[]= FPCDatabase.accsAir(id2);
		double lat1= Math.toRadians(cord1[0]);
		double lat2 = Math.toRadians(cord2[0]);
		double longD =Math.toRadians(cord2[1] - cord1[1]); //longD is the difference of longitude 2 - longitude 1
		double y = Math.sin(longD) * Math.cos(lat2);
		double x = Math.cos(lat1)*Math.sin(lat2) -( Math.sin(lat1)*Math.cos(lat2)*Math.cos(longD));
		double course= Math.toDegrees(Math.atan2(y, x));
		if(course <0){
			course = course + 360;
		}
		return course;
	}
}

