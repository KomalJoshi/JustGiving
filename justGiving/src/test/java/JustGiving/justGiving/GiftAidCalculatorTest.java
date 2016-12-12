package JustGiving.justGiving;

import static org.junit.Assert.*;

import org.junit.Test;


	
public class GiftAidCalculatorTest {
@Test
public void verifyCorrectGiftAidIsCalculatedForCurrentTaxRate()
{
 	double donation = 100;
 	double taxRate = 10.0;
 	GiftAidCalculator.setTaxRate(taxRate);
 	double giftAidAmount = GiftAidCalculator.giftAidAmount(donation);
 	System.out.println( "<----The giftaid in test is : "+ giftAidAmount + " ---->" );
 	assertEquals("The gift aid calcualted on current tax rate "+taxRate +" is not correct -", 11.11,  giftAidAmount, 0.01);	
}

@Test
public void verifyTaxRateIsReadFromConfig()
{
 
 	//Reading the taxRate from config file
 	double taxRate =  GiftAidCalculator.getProperties();
 	System.out.println( "<----The giftaid in test is :  ---->" );
 	assertEquals("The tax rate is not read from the config file - ",20,  taxRate, 0.01);	
}

@Test
public void verifyGiftAidIsCalculatedOnTaxRateFromConfigFile()
{
 	double donation = 100;
 	//Reading the taxRate from config file
 	double taxRate =  GiftAidCalculator.getProperties();
 	GiftAidCalculator.setTaxRate(taxRate);
 	double giftAidAmount = GiftAidCalculator.giftAidAmount(donation);
 	System.out.println( "<----The giftaid in test is : "+ giftAidAmount + " ---->" );
 	assertEquals("The gift aid is not calucalted with tax rate from config file - ",25,  giftAidAmount, 0.01);	
}

@Test
public void verifyGiftAidIsRoundedUpToTwoDigits()
{
 	double donation = 5.264;
 	//Reading the taxRate from config file
 	double taxRate =  GiftAidCalculator.getProperties();
 	GiftAidCalculator.setTaxRate(taxRate);
 	double giftAidAmount = GiftAidCalculator.giftAidAmount(donation);
 	System.out.println( "<----The giftaid in test is : "+ giftAidAmount + " ---->" );
 	// The actual gift aid is 1.316 it should be rounded to 1.32
 	assertEquals("The gift aid is not rounded up correctly - ",1.32,  giftAidAmount, 0.01);	
}

@Test
public void verifyGiftAidIsRoundedDownToTwoDigits()
{
 	double donation = 5.256;
 	//Reading the taxRate from config file
 	double taxRate =  GiftAidCalculator.getProperties();
 	GiftAidCalculator.setTaxRate(taxRate);
 	double giftAidAmount = GiftAidCalculator.giftAidAmount(donation);
 	System.out.println( "<----The giftaid in test is : "+ giftAidAmount + " ---->" );
 	// The actual gift aid is 1.316 it should be rounded to 1.32
 	assertEquals("The gift aid is not rounded down correctly - ",1.31,  giftAidAmount, 0.01);	
}

@Test
/**
 * Checking the boundary values. This test is failing because the value is not rounding correctly
 * */
public void verifyGiftAidIsRoundedUpTwoDigitsForEquiDistantValues()
{
 	double donation = 5.26;
 	//Reading the taxRate from config file
 	double taxRate =  GiftAidCalculator.getProperties();
 	GiftAidCalculator.setTaxRate(taxRate);
 	double giftAidAmount = GiftAidCalculator.giftAidAmount(donation);
 	System.out.println( "<----The giftaid in test is : "+ giftAidAmount + " ---->" );
 	// The actual gift aid is 1.315 it should be rounded to 1.32
 	assertEquals("The gift aid is not rounded up correctly for value ending with 5- ",1.32,  giftAidAmount, 0.01);	
}


}
