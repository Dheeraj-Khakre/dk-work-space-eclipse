package Stream_API;

import java.util.ArrayList;
import java.util.List;


import java.util.stream.Collectors;
import java.util.stream.Stream;
// filter Method in Stream api 
public class Stream_Demo_Filter_Method {
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
	Stream<Integer> stream = al.stream();
//	System.out.println(stream.count());// all method of the stream api is terminate method one we used the Stram object we can use another method  
	List<Integer> al2   =  stream.filter(i -> i%5 == 0).collect(Collectors.toList());
	      System.out.println(al2);
	
	      List<String> list= new ArrayList<>();
	      list.add("harshit");
	      list.add("harini");
	      list.add("harshita");
	      list.add("chiku");
	      list.add("dk mid");
	      list.add("hamita");
	        Stream<String> stream2=     list.stream();
	       List<String> list2=     stream2.filter(i->  i.startsWith("ha")).collect(Collectors.toList());
	       System.out.println(list2);
	      
	      
	}
}
