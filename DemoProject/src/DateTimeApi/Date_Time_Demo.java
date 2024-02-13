package DateTimeApi;



import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Set;



public class Date_Time_Demo {
	public static void main(String[] args) {

		LocalDateTime dateTime= LocalDateTime.now();
		LocalDate date= LocalDate.now();
		LocalDate date2= LocalDate.of(2023,9,21);
        LocalTime time= LocalTime.now();
		System.out.println(dateTime);
		System.out.println(date);
		System.out.println(time);
		Set<String> set = ZoneId.getAvailableZoneIds();
		System.out.println(set);
		System.out.println(date2);
		// set date time format 
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date3 =date.format(dtf);
		System.out.println(date3);
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM-yyyy-dd")));
		
		/// String into date 
		
		String newDate ="12-22-2023";
		DateTimeFormatter dtf1= DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate newDate1 = LocalDate.parse(newDate, dtf1) ;
		System.out.println(newDate1);
		
		
		// instant 
		Instant i = Instant.now();
		System.out.println(" new Instant of "+i);
		
		// period of time 
		
		Period period = Period.ofDays(45);//ofMonths()// OfYears()
	   Temporal t =	period.addTo(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	   System.err.println( "period of time for 45 day "+t);
		
	}

}
