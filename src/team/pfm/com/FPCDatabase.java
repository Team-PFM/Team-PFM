package team.pfm.com;
/*Database Class
 * This class is responsible for initializing and operating on a "database" that holds airport
 * ID's and lat/long coordinates. This data is used for calculations in other classes.
 * Created by Michael Kouremetis
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FPCDatabase {

	 //variables
	static ArrayList airID;
	static ArrayList lat;
	static ArrayList lon;
	static File info = new File("airports.txt");
	
	//methods
	
	//initialize method creates arrays and populates them by reading in text file
	public static void initAir(){
		airID = new ArrayList(30);
		lat = new ArrayList(30);
		lon = new ArrayList(30);
		int counter = 0;
		try {
			Scanner input = new Scanner(info);
			while(input.hasNext()){
				String id = input.next();
				double lat1 = input.nextDouble();
				double lon1= input.nextDouble();
				airID.add(counter,id);
				lat.add(counter, lat1);
				lon.add(counter,lon1);
				counter = counter + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("airports.txt file could not be found");
			e.printStackTrace();
		}
	}
	//method adds new airport ID's and info added by the user
	public static void addAir(String id, double latitiude, double longitude){
		boolean idInUse = false;
		//this first checks to see if the id is already in use or not
		for(int i=0;i<airID.size();i++){
			if(airID.get(i).toString().equalsIgnoreCase(id)){
				idInUse= true;
			}
		}
		if(idInUse ==false){
			airID.add(id);
			lat.add(latitiude);
			lon.add(longitude);
		}
	}
	//method deletes airport ID and info from "database"
	public static void delAir(String id){
		int idToDelete= 0; //making this 0 is okay initially bc the removal of the data will not occur unless idFound is set to true
		boolean idFound = false;
		//finding the tuple id for the ID to delete
		for(int i=0;i<airID.size();i++){
			if(airID.get(i).toString().equalsIgnoreCase(id)){
				idToDelete = i;
				idFound = true;
			}
		}
		//deleting the tuple if it was found
		if(idFound){
			airID.remove(idToDelete);
			lat.remove(idToDelete);
			lon.remove(idToDelete);
		}	
	}
	
	//method to access airport lat and long coordinates
	public static double[] accsAir(String id){
		double []cord = new double[2];
		int idToAccs= 0;//making this 0 is okay initially bc the access of the data will not occur unless idFound is set to true
		double latitude, longitude;
		boolean idFound = false;
		//finding tuple that matches ID to get lat and long
		for(int i=0;i<airID.size();i++){
			if(airID.get(i).toString().equalsIgnoreCase(id)){
				idToAccs = i;
				idFound = true;
			}
		}
		//if id is found, gets lat and long and puts them in the array to be passed.
		if(idFound){
			latitude = (Double) lat.get(idToAccs);
			longitude = (Double)lon.get(idToAccs);
			cord[0]= latitude;
			cord[1]= longitude;
		}
		return cord;//returns the array of lat in first spot and long in second spot
	}
	
	
}
