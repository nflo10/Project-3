public interface BookValue 
{
  public String identifyContract();// returns the contract number, policy number, or other unique identifier as a String value.
  public double calcExposure();// returns a double representing the total possible exposure if the contract becomes immediately, whooly payable.
  public double calcCurrentValue();// Returns a double representing the current total book value of the contract. 
}// end public interface BookValue