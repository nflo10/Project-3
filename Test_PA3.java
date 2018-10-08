/**
 * 
 */

import java.util.Scanner;

public class Test_PA3
{
  public static void main(String[] args)
  {
    Auto[] autoArray = new Auto[3];
    HomeOwners[] homeArray = new HomeOwners[3];
    
    int[] lims = {100,200,300};
    
    try
    {
      System.out.printf( "%nBuilding object 1 - Auto set methods%n%n" );
      
      Auto auto = new Auto();
      
      auto.setExposureRate();
      auto.setMakeModel("Ford Fusion");
      auto.setModelYear(2014);
      auto.setVin("ASDFAF1FAPFF2FDFR");
      auto.setLimits(lims);
      auto.setDeduct(250);
      
      System.out.printf("Object get methods%n\t%f%n\t%s%n\t%d%n\t%s%n\t%d%n\t%d%n\t%d%n\t%d%n%n",
                        auto.getExposureRate(), 
                        auto.getMakeModel(),
                        auto.getModelYear(),
                        auto.getVin(),
                        auto.getLimits()[0],
                        auto.getLimits()[1],
                        auto.getLimits()[2],
                        auto.getDeduct() );
      
      System.out.printf( "Building object 2 - HomeOwners set methods%n%n" );
      
      HomeOwners home = new HomeOwners();
      
      home.setExposureRate();
      home.setPropAddress("1234 Street");
      home.setPropType(5);
      home.setStructure(10000);
      home.setContents(1000);
      home.setDeduct(0.01);
      home.setUmbrella(false);
      
      System.out.printf("Object get methods%n\t%f%n\t%s%n\t%d%n\t%d%n\t%d%n\t%f%n\t%b%n%n",
                        home.getExposureRate(), 
                        home.getPropAddress(),
                        home.getPropType(),
                        home.getStructure(),
                        home.getContents(),
                        home.getDeduct(),
                        home.getUmbrella() );
      
      
      
      System.out.printf( "Building object 3 - Auto%n" );
      
      autoArray[0] = new Auto("Nick", 
                              "Aldo", 
                              "Aa12345",
                              1000,
                              "Ford Fusion",
                              2019,
                              "ASDFASNFRSDFFSDFP",
                              lims,
                              250);
      
      System.out.printf("%ntoString method: %n%n%s", autoArray[0].toString() );
      
      System.out.printf( "%nBuilding object 4 - Auto%n" );
      
      autoArray[1] = new Auto("Ryan ", 
                              "Jim", 
                              "aa12345",
                              1000,
                              "Ford Fusion",
                              1998,
                              "1S5FASMFAS11DASD2",
                              lims,
                              500 );
   
      System.out.printf( "%nBuilding object 5 - Auto%n" );
      
      autoArray[2] = new Auto("Aldo", 
                              "Jim", 
                              "aa12345",
                              1000,
                              "Ford Fusion",
                              2016,
                              "5SDFAS2FASDFASDFW",
                              lims,
                              500 );
      
      System.out.printf( "%nBuilding object 6 - HomeOwners%n" );
      
      homeArray[0] = new HomeOwners("Rick", 
                                    "Jim", 
                                    "aa12345",
                                    1000,
                                    "11300 Expo",
                                    5,
                                    10,
                                    10,
                                    0.1,
                                    true);
      
      System.out.printf("%ntoString method: %n%n%s", homeArray[0].toString() );
      
      System.out.printf( "%nBuilding object 7 - HomeOwners%n" );
      
      homeArray[1] = new HomeOwners("Sam", 
                                    "Jim", 
                                    "aa12345",
                                    1000,
                                    "asdf1234",
                                    1,
                                    10000,
                                    1,
                                    0.1,
                                    true);
      
      System.out.printf( "%nBuilding object 8 - HomeOwners%n" );
      
      homeArray[2] = new HomeOwners("Red", 
                                    "Jim", 
                                    "aa12345",
                                    1000,
                                    "asdf1234",
                                    1,
                                    10000,
                                    1000,
                                    0.1,
                                    false);
    }
    catch( PolicyException xcptn )
    {
      System.out.printf( "%n%s%n", xcptn.getMessage( ) );
    }
    
  }//end main
}//end test_PA3