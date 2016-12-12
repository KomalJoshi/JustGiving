package JustGiving.justGiving;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

/**
 * Just Giving Gift Aid calculator
 *
 */
public class GiftAidCalculator 
{
   
	
	private static double taxRate;
	
	 public static void main( String[] args )
	    {
	        System.out.println( "Hi in main" );
	        getProperties();
	        //Reading the taxRate from config file
	        setTaxRate(getProperties());
	        //setGiftAid(100);
	        System.out.println("The gift calcualted is " + giftAidAmount(100));
	     
	    }
	
	public static double getTaxRate()
	{
		System.out.println( "<----In getTaxRate() ---->" );
		return taxRate;
	}
	
	public static void setTaxRate(double value)
	{
		System.out.println( "<----In setTaxRate() ---->" );
		taxRate = value;
		System.out.println( "<----The tax rate is set to: "+ taxRate + " ---->" );
	}
	
	public static double giftAidAmount(double donationAmount)
	{
		System.out.println( "<----The tax rate is set to: "+ taxRate + " ---->" );
		double gaRatio =  taxRate / (100 - taxRate);
		System.out.println( "<----The the ratio is  "+ gaRatio+ " ---->" );
		return round (donationAmount * gaRatio);
	}
	
	public static double round (double value)
	{
		// rounding to two decimal places. The value is rounded up if >= .5 and ronuded down if <= 0.5
		double roundedValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return roundedValue;
	}
	public static double getProperties()
	{
		System.out.println( "<----In getProperties()---->" );
		double taxRate=0.0;
		Properties prop = new Properties();
		try {
		    //load a properties file from class path, inside static method
		    prop.load(GiftAidCalculator.class.getClassLoader().getResourceAsStream("config.properties"));

		    //get the property value and print it out
		    taxRate=Double.parseDouble(prop.getProperty("taxRate"));
		    System.out.println(taxRate);
		  
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		return taxRate;
	}
	
}
