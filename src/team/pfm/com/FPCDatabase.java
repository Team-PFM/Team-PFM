package team.pfm.com;
/*Database Class
 * This class is responsible for initializing and operating on a "database" that holds airport
 * ID's and lat/long coordinates. This data is used for calculations in other classes.
 * Created by Michael Kouremetis
 */

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FPCDatabase {
	
	 //variables
	private ArrayList airID;
	private ArrayList lat;
	private ArrayList lon;
	private File defaultList = new File("defaultAirports41.txt");
	
	//methods
	//constructor
	//initialize default  arrays and populates them by reading in default text file
	public FPCDatabase(){
		airID = new ArrayList(30);
		lat = new ArrayList(30);
		lon = new ArrayList(30);
		int counter = 0;
		try {
			Scanner input = new Scanner(defaultList);
			while(input.hasNextLine()){
				String a = input.nextLine();
				StringTokenizer st = new StringTokenizer(a, ",");
				String id = st.nextToken();
				double lat1 = Double.parseDouble(st.nextToken());
				double lon1= Double.parseDouble(st.nextToken());
				airID.add(counter,id);
				lat.add(counter, lat1);
				lon.add(counter,lon1);
				//System.out.println(id + "  " + lat1 + "  " + lat1); for tests
				counter = counter + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("defaultAirports41.txt file could not be found");
			e.printStackTrace();
		}
	}
	
	//initialize custom method creates arrays and populates them by reading in default text file, you pass the whole name of the file ex: "name.txt"
	public  void initAirCustom(String file){
		this.ClearDB();//fisrt gets rid of the values in the database before loading it with the new file
		int counter = 0;
		try {
			Scanner input = new Scanner(new File (file));
			while(input.hasNextLine()){
				String a = input.nextLine();
				StringTokenizer st = new StringTokenizer(a, ",");
				String id = st.nextToken();
				double lat1 = Double.parseDouble(st.nextToken());
				double lon1= Double.parseDouble(st.nextToken());
				airID.add(counter,id);
				lat.add(counter, lat1);
				lon.add(counter,lon1);
				//System.out.println(id + "  " + lat1 + "  " + lat1); for tests
				counter = counter + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println(file + " file could not be found");
			e.printStackTrace();
		}
		}
	
	
	//check method checks to make sure the file syntax is of proper from, ex: " ID, lat(in radians), long(in radians) "
	//pass the full file name : "name.txt"
	public static boolean checkFileExistAndSyntax(String file){
		boolean status = true; //assumes text file is correct initially
		double tokensMatch;//every line read from the text file should have 3 tokens separated from commas : ID, Lat, Long
		
				try {
					File fileTT = new File(file);
					Scanner inputCh = new Scanner(fileTT);
					while(inputCh.hasNextLine()){
						String line = inputCh.nextLine();
						StringTokenizer a = new StringTokenizer(line, ",");
						tokensMatch = a.countTokens();
						try{
							String id = a.nextToken();
							double latT = Double.parseDouble(a.nextToken());
							double lonT= Double.parseDouble(a.nextToken());
						
						}catch( NoSuchElementException e ){//catching if any parsing of the tokens does not match double or string format
							status = false;
							break; //exiting loop since tokens are not of proper format
						}
							//now making sure the syntax and commas are correct
							if(tokensMatch != 3 ){
								status = false;
								break; //exiting loop since at least one line is not written correctly
							} 
					}
				} catch (FileNotFoundException e) {
					status = false;//catching the error is the file is not found
				}
				
				return status;
			}
			
		
	
	
	
	//method adds new airport ID's and info added by the user
	public  void addAir(String id, double latitiude, double longitude){
		boolean idInUse = false;
		int idLoc =0;
		//this first checks to see if the id is already in use or not
		for(int i=0;i<airID.size();i++){
			if(airID.get(i).toString().equalsIgnoreCase(id)){
				idInUse= true;
				idLoc= i;
			}
		}
		if(idInUse ==false){ //if the id is not in use, just adds the new id
			airID.add(id);
			lat.add(latitiude);
			lon.add(longitude);
		}
		else if(idInUse==true){ //if the id is in use, it replaces that id
			airID.set(idLoc, id);
			lat.set(idLoc, latitiude);
			lon.set(idLoc, longitude);
		}
	}
	//method deletes airport ID and info from "database"
	public void delAir(String id){
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
	
	//method to access airport lat and long coordinates, if there is no airport for the ID, it returns "1000000" for cord(kind of like an error code)
	public  double[] accsAir(String id){
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
		else {
			cord[0] = 1000000;
		}
		return cord;//returns the array of lat in first spot and long in second spot
	}

	//method to clear the database in preparation for custom db list
	public void ClearDB(){
		airID.clear();
		lat.clear();
		lon.clear();
	}
	

}
