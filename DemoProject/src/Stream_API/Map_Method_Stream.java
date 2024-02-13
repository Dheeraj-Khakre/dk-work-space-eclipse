
package Stream_API;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map_Method_Stream {
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
		List<Integer>	al2= al.stream().map(t-> t*2).collect(Collectors.toList());
		//List<Integer>	al2= al.stream().map(t-> t*2).filter(i-> i>50).collect(Collectors.toList());
		System.out.println(al2);
		
		
	}

}
