import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Holds all the data from each frame and shares it with the main menu
public class DataCoppola 
{
//-------------------Sort-------------------------	
	static String order;
	
	public static void setOrderBy(String newOrder)
	{
		order = newOrder;
	}//setOrderBy
	
	public static String getOrderBy()
	{
		return order;
	}//getOrderBy

//-----------------Price Range-----------------------
	static double high =  1000000;
	static String hQuery = "AND RetailPrice <= "+ high;
	static double low  =  0;
	static String lQuery = "AND RetailPrice >= "+ low;
	
	//sets the Highest Price in the Range 
	public static void setHigh(double newHigh)
	{
		high =  newHigh;
		hQuery = "AND RetailPrice <= "+ high;
	}//setHigh
	
	//Return the high range of the Query
	public static String getHigh()
	{
		return hQuery;
	}//getHigh
	
	//sets the Lowest Price in the Range 
	public static void setLow(double newLow)
	{
		low = newLow;
		lQuery = "AND RetailPrice >= "+ low;
	}//setLow 
	
	//Returns the low range of the Query
	public static String getLow()
	{
		return lQuery;
	}//getLow
	
	public static double getLowPrice()
	{
		return low;
	}//getLowPrice
	
	public static double getHighPrice()
	{
		return high;
	}//getHighPrice

//-----------------Categories-----------------------
	static boolean dairy = true;
	static boolean meat = true;
	static boolean frozen = true;
	static boolean canned = true;
	static boolean produce = true;
	static boolean beverage = true;
	static boolean paper  = true;
	static boolean snack  = true;
	static boolean other  = true;
	
	public static void setDairy(boolean newDairy)
	{
		dairy = newDairy;
	}//setDairy
	
	public static boolean getDairy()
	{
		return dairy;
	}//getDairy
	
	public static void setMeat(boolean newMeat)
	{
		meat = newMeat;
	}//setMeat
	
	public static boolean getMeat()
	{
		return meat;
	}//getMeat
	
	public static void setFrozen(boolean newFrozen)
	{
		frozen = newFrozen;
	}//setFrozen
	
	public static boolean getFrozen()
	{
		return frozen;
	}//frozen
	
	public static void setCanned(boolean newCan)
	{
		canned = newCan;
	}//setCanned
	
	public static boolean getCanned()
	{
		return canned;
	}//getCanned
	
	public static void setProduce(boolean newPro)
	{
		produce = newPro;
	}//setProduce

	public static boolean getProduce()
	{
		return produce;
	}//getProduce
	
	public static void setBeverage(boolean newBev)
	{
		beverage = newBev;
	}//setBeverage
	
	public static boolean getBeverage()
	{
		return beverage;
	}//getBeverage
	
	public static void setPaper(boolean newPaper)
	{
		paper = newPaper;
	}//setPaper
	
	public static boolean getPaper()
	{
		return paper;
	}//getPaper
	
	public static void setSnack(boolean newSnack)
	{
		snack = newSnack;
	}//setSnack
	
	public static boolean getSnack()
	{
		return snack;
	}//getSnack
	
	public static void setOther(boolean newOther)
	{
		other = newOther;
	}//setOther
	
	public static boolean getOther()
	{
		return other;
	}//getOther
	
	
//------------------ADD ITEM--------------------------
	static  String id;
	static 	String name;
	static	String category;
	static	String wholesale;
	static	String retail;
	static	String qoh;
	static	String minQuant;
	static	String clerk;

static boolean signal = false;

	 public static void setID (String newID)
	{
		  id  = newID;
	}//setNewID
	
	 public static String getID()
	 {
		 return id;
	 }//getNewID
	 
	 public static void setName(String newName) 
	 {
		 name = newName;
	 }//setName
	 
	 public static String getName()
	 {
		 return name;
	 }//getName
	 
	 public static void setCat(String newCat)
	 {
		 category = newCat;
	 }//setCategory
	 
	 public static String getCat() 
	 {
		 return category;
	 }//getCategory
	 
	 public static void setWhole(String newWhole)
	 {
		 wholesale = newWhole;
	 }//setWholeSale
	 
	 public static String getWhole()
	 {
		 return wholesale;
	 }//getWholeSale
	 
	 public static void setRetail(String newRetail)
	 {
		 retail = newRetail; 
	 }//setRetail
	 
	 public static String getRetail()
	 {
		 return retail;
	 }//getRetail
	 
	 public static void setQOH(String newQOH)
	 {
		 qoh = newQOH;
	 }//setQuantityOnHand
	 
	 public static String getQOH()
	 {
		 return qoh;
	 }//getQuantityOnHand
	 
	 public static void setMinQuant(String newMinQuant)
	 {
		 minQuant = newMinQuant;
	 }//setMinQuant
	 
	 public static String getMinQuant()
	 {
		 return minQuant;
	 }//getMinQuant
	 
	 public static void setClerk (String newClerk)
	 {
		 clerk = newClerk;
	 }//setClerk
	 
	 public static String getClerk()
	 {
		 return clerk;
	 }//getClerk
	 
	 //Signals to InventoryCoppola if an item is ready to be added
	 public static void signal(boolean newSignal)
	 {
		 signal = newSignal;
	 }//Signal
	 
	 //Tells InventoryCoppola to add the new item
	 public static boolean update()
	 {
		 return signal;
	 }//Update
	 
	
	 
//--------------------
	 
}//DataCoppola
