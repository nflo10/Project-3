public class Annuity implements BookValue {
  
  private String owner;        //Owners fuul name
  private String benificiary;  //Beneficiary's name
  private String contractNbr;  //Contract Number
  private int contractValue;   //Total value of contract
  private double cashBalance;  //Cash value of current annuity
  
  /*
   * CONSTRUCTORS
   */
  
  public Annuity()
  {
    
  }// end null constructor
  
  public Annuity(String own,
                 String beni,
                 String nbr,
                 int value,
                 double bal) 
  {
    super();
    setOwner(own);
    setBeneficiary(beni);
    setContractNbr(nbr);
    setContractValue(value);
    setCashBalance(bal);
  }// end full constructor 
  
  /*
   * SET METHODS
   */
  
  public final void setOwner(String own)
  {
    owner = own;
  }// end setOwner
  
  public final void setBeneficiary(String beni)
  {
    benificiary = beni;
  }// end setBeneficiary
  
  public final void setContractNbr(String nbr) 
  {
    contractNbr = nbr;
  }// end setContractNbr
  
  public final void setContractValue(int value)
  {
    contractValue = value;
  }// end setContractValue
  
  public final void setCashBalance(double balance)
  {
    cashBalance = balance;
  }// end setCashBalance
  
  /*
   * GET METHODS
   */
  
  public final String getOwner() 
  {
    return owner;
  }// end getOwner
  
  public final String getBeneficiary()
  {
    return benificiary;
  }// end beneficiary
  
  public final String getContractNbr() 
  {
    return contractNbr;
  }// end getContractNbr
  
  public final int getContractValue() 
  {
    return contractValue;
  }// end getContractValue
  
  public final double getCashBalance() 
  {
    return cashBalance;
  }// end getCashBalance
  
  public final String identifyContract() 
  {
    return contractNbr;
  }// end identifyContract
  
  public double calcExposure() 
  {
    return getContractValue()-getCashBalance();
  }// end calcExposure
  
  public double calcCurrentValue()
  {
    return cashBalance;
  }// end calcCurrentValue
  
  public String toString() 
  {
    return String.format("%s own an Annuity contract, %s, benefitting %s. Total contract value is $%,d.00"+
                         " Current cash value is $%,.2f.\n",
                         getOwner(),
                         getContractNbr(),
                         getBeneficiary(),
                         getContractValue(),
                         getCashBalance());
  }// end toString
}// end class Annuity implements BookValue