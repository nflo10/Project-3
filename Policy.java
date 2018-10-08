/* 
 * This is a program that produces output of a policy owner's full name, who is insured, what type of policy
 * they have, and the amount of the premium of the policy. 
 */
import java.util.regex.Pattern;           // Access to the PATTERN class
import java.util.regex.Matcher;           // access to Matcher class 

public abstract class Policy implements BookValue {
  
  private String owner;           // policy owners full, legal name
  private String insured;         // full, legal name of names insured on policy 
  private String polNbr;          // unique identifier for specific policy 
  private double polPrem;         // annual premium amount for policy 
  
  /*
   * CONSTRUCTORS
   */
  public Policy( )
  {
    // This is intended to be empty 
  }  //end null constuctor
  
  public Policy(String own,
                String insd, 
                String nbr,
                double prem)
    throws PolicyException
  {
    try
    { 
      setOwner( own );
      setInsured( insd );
      setPolNbr( nbr );
      setPolPrem( prem );
    }//end try block
    catch(PolicyException policyErr)
    {
      String policyInfo = policyErr.getMessage();
      String policyInfo2 = String.format("%s%nThe Policy values offered: %n " +
                                         "\t owner: %s %n \t insured: %s %n " +
                                         "\t polNbr: %s %n \t polPrem: %.2f %n ", 
                                         policyInfo,
                                         own,
                                         insd,
                                         nbr,
                                         prem);
      
      // Chaining the exception
      throw new PolicyException(policyInfo2, policyErr);
    }//end catch PolicyExceptioin
  } //end full constructor 
  
  
  /*
   * SET METHODS
   */ 
  public final void setOwner(String own)
    throws PolicyException
  {
    /*
     * if else statement that test validty of the owner's name if name does not meet requirments, then exception is thrown.
     */
    if ( own == null || own.matches( "^ +" ) || own.length( ) == 0 )
    {
      throw new PolicyException("The owner's legal full name is missing. Please enter a valid full legal name.");
    }
    else
    {
      owner = own;
    }
  }  // end setOwner
  
  public final void setInsured(String insd)
    throws PolicyException
  {
    /*
     * if else statement that test validity of the insured's name if name does not meet requirments, then exception is thrown.
     */
    if(insd == null || insd.matches("^ +") || insd.length() == 0)
    {
      throw new PolicyException("The insured's legal full name is missing. Please enter a valid full legal name.");
    }
    else
    {
      insured = insd;
    }
  }  //end setInsured
  
  public final void setPolNbr(String nbr) 
    throws PolicyException    
  {
    String testNbr = "([a-zA-Z]{2}+\\d{5})";
    //                 [a-zA-Z]{2} TESTS THE FIRST TWO CHARACTERS FOR a-z AND A-Z
    //                             \\d{5} TESTS THE LAST FIVE CHARACTERS FOR DIGITS
    
    //Compile the regular expression into a Pattern object
    Pattern nbrPattern = Pattern.compile( testNbr ); 
    
    //Create a Matcher object to tie the Pattern object to the CURRENT string
    Matcher nbrMatcher = nbrPattern.matcher( nbr );
    
    /*
     * if else statement that tests the validity of the policy number. If the policy number is not valid an exception
     * is thrown.
     */
    if(nbrMatcher.matches( )) // if matches assigned value
    {
      polNbr = nbr;
      
    }
    else
      throw new PolicyException("Invalid policy number, please enter a policy number begining with two letters A-Z only followed by five digits 0-9.");
  }// end setPolNbr
  
  public final void setPolPrem(double prem)
  {
    polPrem = prem;
  }// end setPolPrem
  
  /*
   * GET METHODS
   */
  public final String getOwner() 
  {
    return owner;
  }// end getOwner
  
  public final String getInsured() 
  {
    return insured;
  }// end getInsured
  
  public final String getPolNbr() 
  {
    return polNbr;
  }// end getPolNbr
  
  public final double getPolPrem()
  {
    return polPrem;
  } // end getPolPrem
  
  /*
   * OTHER METHODS AS NEEDED
   */
  public String identifyContract() 
  {
    return polNbr;
  } //end identifyContract
  
  public String toString() 
  {
    // Return a verbose description of the Policy Object. 
    return String.format( "%s owns Policy %s, insuring %s, with a premium of $%,.2f.%n", new Object[] {
      getOwner(),
        getPolNbr(),
        getInsured(),
        Double.valueOf(getPolPrem())});
  }// end toString
  
}// end abstract class Policy implements BookValue