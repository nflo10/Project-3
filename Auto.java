import java.util.regex.Pattern;          // Access to the PATTERN class
import java.util.regex.Matcher;          // access to Matcher class 

public class Auto extends Policy
{
  
  private double exposureRate =0.0051;   // current exposure rate for Auto policies is 0.00051. Constant value set directly in the set method. No data will be passed into constructor.  
  private String makeModel;              // make and model of auto
  private int modelYear;                 // model year of auto 
  private String vin;                    // vehicle identification number
  private int[] limits=new int[3];       //array for int values representing coverage limits (in thousands of dollars) 
  private int deduct;                    // policy deductible stated in dollars
  
  /*
   * CONSTRUCTORS
   */
  public Auto() 
  {
    super();
  }// end null constructor
  
  public Auto (String own,           // owed to SUPERCLASS
               String insd,          // owed to SUPERCLASS
               String nbr,           // owed to SUPERCLASS
               double prem,          // owed to SUPERCLASS
               String model,         // owed to SUBCLASS
               int year,             // owed to SUBCLASS
               String id,            // owed to SUBCLASS
               int[ ] lims,          // owed to SUBCLASS
               int ded)              // owed to SUBCLASS
    throws PolicyException
  { 
    super(own,                       // owed to SUPERCLASS
          insd,                      // owed to SUPERCLASS
          nbr,                       // owed to SUPERCLASS
          prem);                     // owed to SUPERCLASS
    try
    {
      setMakeModel( model );         // owed to SUBCLASS         
      setModelYear( year );          // owed to SUBCLASS
      setVin( id );                  // owed to SUBCLASS
      setLimits( lims );             // owed to SUBCLASS
      setDeduct( ded );              // owed to SUBCLASS
    } // end try block
    catch(PolicyException autoErr)   // chained exception
    {
      String autoInfo = autoErr.getMessage( );
      String autoInfo2 = String.format("%s%nAuto values offered: %n " +
                                       "\t owner: %s %n \t insured: %s %n " +
                                       "\t polNbr: %s %n \t polPrem: %.2f %n" +
                                       "\t makeModel: %s %n \t modelYear: %d %n " +
                                       "\t vin: %s %n \t limits: $%d, $%d, $%d %n " +
                                       "\t deduct: %s %n ", autoInfo, 
                                       own, 
                                       insd, 
                                       nbr, 
                                       prem, 
                                       model,
                                       year, 
                                       id, 
                                       lims[0],
                                       lims[1],
                                       lims[2],
                                       ded);
      
      throw new PolicyException(autoInfo2, autoErr);
    }// end catch PolicyException 
    
  }// end full constructor Auto 
  
  /*
   * SET METHODS
   */
  public final void setExposureRate( )
  { 
    exposureRate = 0.0051;
  }// end setExposureRate
  
  public final void setMakeModel(String model) 
  {
    makeModel = model;
  }// end setMakeModel
  
  public final void setModelYear(int year) 
    throws PolicyException
  {
    if (year > 1997 && year <=2019)
    {
      modelYear = year;
    }
    else 
    {
      throw new PolicyException("Invalid model year of vehicle, vehicle year must be newer than 1997 and no greater than 2019.");
    }
  }// end setModelYear
  
  public final void setVin(String id) 
    throws PolicyException
  { 
    // Declare the regular Expression (regex)
    String testId = "([A-HJ-NPR-Z0-9]){17}";
    //                [A-HJ-NPR-Z0-9] VIN MUST INCLUDE CHARACTERS FROM A-H, J-N, P, R-Z & 0-9
    //                                {17} VIN MUST BE EXACTLY 17 CHARACTERS
    
    //Compile the regular expression into a Pattern object
    Pattern idPattern = Pattern.compile( testId ); 
    
    //Create a Matcher object to tie the Pattern object to the CURRENT string
    Matcher idMatcher = idPattern.matcher( id );
    
    /*
     * if else statement to test VIN for requirments need. If VIN does not meet requirements then exception is thrown.
     */
    if( idMatcher.matches() )
    {
      vin = id;
    }
    else
    {
      throw new PolicyException("This is not a valid VIN, please enter a 17 character VIN in all capital letters excluding I,O & Q and including numbers ranging from 0-9.");
    }
  }// end setVin
  
  public final void setLimits(int[] lims)
  {
    limits = lims;
  }// end setLimits
  
  public final void setDeduct(int ded) 
    throws PolicyException
    
    /*
     * if else statement to test values of ded. If value does not satisfy requirments, then exception is thrown.
     */
  {
    if((ded == 250) || (ded == 500) || (ded == 750) || (ded == 1000))
    {
      deduct = ded;
    }
    else
      throw new PolicyException("Invalid deductable, acceptable deductable amounts are $250, $500, $750 or $1000.");
  }// end setDeduct
  
  /*
   * GET METHODS
   */
  
  public final double getExposureRate()
  {
    return exposureRate;
  }// end getExposureRate
  
  public final String getMakeModel()
  {
    return makeModel;
  }// end getMakeModel
  
  
  
  public final int getModelYear() 
  {
    return modelYear;
  }// end getModelYear
  
  
  public String getVin()
  {
    return vin;
  }// end getVin
  
  
  public final int[] getLimits()
  {
    return limits;
  }// end getLimits
  
  public final int getDeduct() 
  {
    return deduct;
  }// end getDeduct
  
  /*
   * OTHER METHODS AS NEEDED
   */
  
  
  public String produceLimitsTxt()
  {
    return String.format( "of Collision: $%,.2f, Comprehensive: $%,.2f, UIM: $%,.2f ",
                         ( double )( 1000*limits[0] ),
                         ( double )( 1000*limits[1] ),
                         ( double )( 1000*limits[2] ) );
  }// end produceLimitsTxt
  
  public double calcExposure()
  {
    {
      double amount = 0;
      int[] total = getLimits( );
      
      for( int camaro : total )
      {
        amount += camaro*1000;
      } // end enhanced for loop
      return amount;
    }
  }// end calcExposure
  
  public double calcCurrentValue()
  {
    return getPolPrem()-(calcExposure()*getExposureRate());
  }// end calcCurrentValue
  
  public String toString() {
    return String.format( "%sThis %s policy insures a %d %s, VIN %s with limits %s and a deductible of $%,d.00.%n", 
                         super.toString(), 
                         getClass().getName(),
                         getModelYear(),
                         getMakeModel(),
                         getVin(),
                         produceLimitsTxt(),
                         getDeduct());
  }// end toString
  
}// end class Auto extends Policy