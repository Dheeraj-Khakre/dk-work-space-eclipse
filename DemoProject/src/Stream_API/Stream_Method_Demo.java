package Stream_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;


public class Stream_Method_Demo {
	public static void main(String[] args) {
        List<Integer> al= new ArrayList<Integer>();
        al.add(12);
		al.add(10);
		al.add(17);
		al.add(12);
		al.add(19);
		al.add(18);
		al.add(60);
		al.add(15);
		Optional<Integer> x=	 al.stream().max((o1, o2) -> {
			if (o1>o2)
				return 1;
			else if(o2>o1)
				return -1;
			else return 0;
		});
	
	System.out.println(x);
	 System.out.println(al.stream().max((o1, o2) ->  o1-o2));
	 System.out.println(al.stream().min((o1, o2) ->  o1-o2));
	
				 
	//al=	al.stream().filter(t-> t%2==0).map(i-> i*10).sorted().distinct().collect(Collectors.toList());
	System.out.println(al);
	Optional<Integer> x2=al.stream().findFirst();
	System.out.println(x2);
	//al= al.stream().sorted((i,j)->j-i).collect(Collectors.toList());
	System.out.println(al);
	

       Collections.sort(al,(i,j)->j-i);
       System.out.println(al);
	
			}

}
