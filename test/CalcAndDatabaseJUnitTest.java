/*Team PFM
 * FPC System
 * JUnit test class for the calculations and database classes
 * Proprietary Source Code
 * Created by Michael Kouremetis 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import team.pfm.com.Calculations;

public class CalcAndDatabaseJUnitTest {
	
	//testing the calculations class
	
	//testing true airspeed calculation
	
	@Test
	public void AirSpeedCalcTest(){
		assertEquals(600,Calculations.calcTrueAsp(10000, 500),0);
		
	}
	
	//testing density altitude calculation
	@Test
	public void densAltCalcTest(){
		assertEquals(42410,Calculations.calcDensAlt(50, 33000),0);
		
	}
	
	//testing run way winds calculation
	@Test
	public void runwayWindsTest(){
		double []val = Calculations.calcRunWinds(10,60, 45);
		assertEquals(2.55,val[0],.08); //val[0] is xwind speed
		assertEquals(1,val[2],0);//val[1] is the xwind direction as in 1= coming froom right   2= coming from left
		assertEquals(9.65,val[1],.08);//val[1] is hwind speed
		assertEquals(2,val[3],0);// val[3] is hind direction as in 1= tailwind  2 = true headwind
		
	}
	
	
	//testing wind direction calculation
	@Test
	public void windDirectionTest(){
		assertEquals(126,Calculations.calcWindDir(500, 550, 60, 70),0);
	}
	
	//testing wind correction angle calc
	@Test
	public void windCorAngleTest(){
		assertEquals(2,Calculations.calcCorAng(20, 100, 400, 60),0);
	}
	
	
	//
	
	
}
