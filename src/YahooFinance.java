import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class YahooFinance {
  public static double getPrice(final String ticker) {
    try {
    	//https://quantprice.herokuapp.com/api/v1.1/scoop/day?tickers=MSFT&date=2017-06-09
    	
      final URL url = 
        new URL("https://www.google.com/finance/info?q=" + ticker );

      final BufferedReader reader = 
        new BufferedReader(new InputStreamReader(url.openStream()));
      Stream<String> s = reader.lines();
      /*List<Double>*/ double price = s
    		  //.peek(ll -> System.out.println(" peek : " + ll))
    		  .filter(p -> p.contains("\"l_cur\""))
    		  .map(p -> {
    			  int start = p.indexOf(":");
    			  return p.substring(start + 1);
    		  })
    		  .map(p -> p.replace('"', ' '))
    		  .mapToDouble(Double::parseDouble)
    		  .findFirst()
    		  .getAsDouble();
    		 // .collect(Collectors.toList());
 //     System.out.println("price : " + price);
   //   	double price = reader.lines().peek(System.out::println).mapToDouble(json -> {System.out.println(ticker + " JSON " + json); return 77.77;}).findFirst().getAsDouble();
//      final String data = reader.lines().skip(1).limit(1).findFirst().get();
//      final String[] dataItems = data.split(",");
//      double price = Double.parseDouble(dataItems[dataItems.length - 1]);      
      return price;
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
