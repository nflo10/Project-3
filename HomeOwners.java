/*
 * This code describes a HomeOwners object.
 * the HomeOwners class is a SUBCLASS of Policy.
 * Policy is the SUPERCLASS of HomeOwners.
 * This is what a heirachy looks like:
 * 
 *          Policy (SUPERCLASS)
 *                  HomeOwners(SUBLCASS)
 */
public class HomeOwners extends Policy 
{
  private double exposureRate = .0025;
  private String propAddress;
  private int propType;
  private int structure;
  private int contents;
  private double deduct;
  private boolean umbrella;
  
  /*
   * CONSTUCTORS
   */
  
  
  public HomeOwners() 
  {
    super();
  }
  
  public HomeOwners(String own,    //owed to SUPERCLASS
                    String insd,   //owed to SUPERCLASS
                    String nbr,    //owed to SUPERCLASS
                    double prem,   //owed to SUPERCLASS
                    String addr,   //SUBCLASS variable
                    int type,      //SUBCLASS variable
                    int struct,    //SUBCLASS variable
                    int goods,     //SUBCLASS variable
                    double ded,    //SUBCLASS variable
                    boolean umbr)  //SUBCLASS variable
    throws PolicyException
  {
    // THE FIRST EXECUTABLE STATEMENT HERE MUST BE A CALL TO 
    // THE SUPERCLASS CONSTRUCTOR
    super(own,    //owed to SUPERCLASS
          insd,   //owed to SUPERCLASS
          nbr,    //owed to SUPERCLASS
          prem);  //owed to SUPERCLASS
    try
    {
      setPropAddress(addr);
      setPropType(type);
      setStructure(struct);
      setContents(goods);
      setDeduct(ded);
      setUmbrella(umbr);
    }// end try
    catch(PolicyException homeErr)
    {
      String homeInfo = homeErr.getMessage( );
      String homeInfo2 = String.format("%n %s %n Values offered: %n " +
                                       "\t owner: %s %n \t insured: %s %n " +
                                       "\t polNbr: %s %n \t polPrem: %.2f %n" +
                                       "\t propAddress: %s %n \t propType: %d %n " +
                                       "\t structure: %d %n \t contents: %d %n " +
                                       "\t deduct: %f %n \t umbrella: %b %n",
                                       homeInfo,
                                       own,
                                       insd,
                                       nbr,
                                       prem,
                                       addr,
                                       type,
                                       struct,
                                       goods,
                                       ded,
                                       umbr);
      
      throw new PolicyException(homeInfo2, homeErr);
    }// end catch PolicyException
  }//END Full Constructor
  
  public final void setExposureRate() 
  {
    exposureRate = 0.0025;
  }// end setExposureRate
  
  public final void setPropAddress(String addr) 
  {
    propAddress = addr;
  }// end setPropAddress
  
  public final void setPropType(int type) 
    throws PolicyException
  {
    /*
     * if else statement to test propType if not type 1, 2, 3 or 4 then it default to 1
     */
    if(type == 1 || type == 2 || type ==3 || type ==4)
    {
      propType = type;
    }
    else
    {
      propType = 1;
    } 
  }// end setPropType
  
  public final void setStructure(int struct) 
    throws PolicyException
  {
    /*
     * if else statment to test value of struct if value falls below 1 or more than 10000 then an exception will be thrown.
     */
    if(struct > 0 && struct <= 10000)
    {
      structure = struct;
    }
    else
    {  
      throw new PolicyException("Invalid amount entered, structure coverage limit represented in thousands of dollars must be greater than 0 and less than or equal to 10,000.");
    }
  }// end setStructure
  
  public final void setContents(int goods) 
    throws PolicyException
  {
    /*
     * if else statment to test value of goods if value falls below 1 or more than 1000 then an exception will be thrown.
     */
    if(goods > 0 && goods <= 1000)
    {
      contents = goods;
    }
    else
    {
      throw new PolicyException("Invalid amount entered, contents coverage limit represented in thousands of dollars must be greater than 0 and less than or equal to 1,000.");
    }
  }// end setContents
  
  public final void setDeduct(double ded)
    throws PolicyException
  {
    /*
     * if else statment to test value of ded if value falls below 0.01 or more than 0.10 then an exception will be thrown.
     */
    if(ded >= 0.01 && ded <=0.10)
    {
      deduct = ded;
    }
    else
    {
      throw new PolicyException("Invalid deductable percentage, deductable percentage must be atleast 1% or up to 10%");
    }
  }//end setDedcut
  
  public final void setUmbrella(boolean umbr) 
  {
    umbrella = umbr;
  }// end setUmbrella
  
  /*
   * GET METHODS
   */
  
  public double getExposureRate() 
  {
    return exposureRate;
  }// end getExposureRate
  
  public final String getPropAddress()
  {
    return propAddress;
  }// end getPropAddress
  
  public final int getPropType() 
  {
    return propType;
  }// end getPropType
  
  public final int getStructure()
  {
    return structure;
  }//end getStructure
  
  public final int getContents()
  {
    return contents;
  }// end getContents
  
  public final double getDeduct()
  {
    return deduct;
  }// end getDeduct
  
  public final boolean getUmbrella()
  {
    return umbrella;
  }//end getUmbrella
  
  
  public double getDeductInDollars( )
  {
    return ( structure + contents )*1000 * deduct;
  }//end getDeductInDollars
  
  public double calcExposure( )
  {
    return (getStructure() + getContents())*1000;
  } // end calculateExposure
  
  public double calcCurrentValue()
  {
    return getPolPrem()-(calcExposure()*exposureRate);
  }//end calcCurrentValue
  
  
  public String toString( )
  {
    // if else to test boolean condition that produces string "is not" if false or "is" if else
    String isIsNot;
    if( getUmbrella( ) )
      isIsNot = ("is" );
    
    else
      isIsNot = ( "is not" );
    
    return String.format( "%sThis %s policy insures a type %d home at %s. The structure is " +
                         "insured for $%,d.00; contents for $%,d.00. The deductible is $%,.2f. This policy %s part of an Umbrella Contract. %n",
                         super.toString( ),
                         getClass().getName(),
                         getPropType( ),
                         getPropAddress( ),
                         getStructure( )*1000,
                         getContents( )*1000,
                         getDeductInDollars( ),
                         isIsNot);
  }// end toString
}// end HomeOwners extends Policy 