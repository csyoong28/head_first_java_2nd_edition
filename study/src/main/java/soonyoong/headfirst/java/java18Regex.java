package soonyoong.headfirst.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java18Regex {
	public static void main(String args[]) {
		useCase1();
//		useCase2();
		useCase3();
	}

    public static void useCase1() {
        // String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		System.out.println("groupCount" + m.groupCount());
		if (m.find()) {
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
    }
    
    public static void useCase2() {
        Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        String dateStr = "28/07/1984";
        Matcher m = datePatt.matcher(dateStr);
        if (m.matches()) {
          int day   = Integer.parseInt(m.group(1));
          int month = Integer.parseInt(m.group(2));
          int year  = Integer.parseInt(m.group(3));
          System.out.println(day +"," + month +","+ year);
        }     
    }
    
    public static void useCase3() {
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
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
}
