public class PolicyException extends Exception
  
{
  // The following constructor accepts a message as the only input parameter. This message will be displayed back to the user.

  public PolicyException(String message)
  {
    super(message);
  }// end one-parm constructor
  
  public PolicyException(String message, Throwable cause)
  {
    super(message, cause);
  }// end two-parm constructor
}// end InvalidDateException