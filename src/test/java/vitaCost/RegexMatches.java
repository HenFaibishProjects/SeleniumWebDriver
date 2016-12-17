package vitaCost;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   private static final String REGEX = "\\d+\\.\\d+";
   private static final String INPUT = "cat1 cat cat cattie cat";

   public static void abc() {
      Pattern p = Pattern.compile(REGEX);
      Matcher m = p.matcher(INPUT);   // get a matcher object
      int count = 0;

      while(m.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m.start());
         System.out.println("end(): "+m.end());
      }
   }
   
   public static void main(String[] args) {
	   abc();
	
} 
	

}
