
package Stream_API;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Stream_Map_Interface {
	public static void main(String[] args) {
		Map<Integer , String> map= new HashMap<Integer, String>();
		map.put(1, "dheeraj ");
		map.put(2, "khakre ");
		map.put(3, "dk mid ");
		map.put(4, "night sky ");
		map.put(5, " sushank ");
		//map.stream
		ConcurrentHashMap<Integer, String> conHs = new ConcurrentHashMap<Integer, String>();
		System.out.println(map);
		conHs.put(1, "dheeraj ");
		conHs.put(2, "khakre ");
		conHs.put(3, "dk mid ");
		conHs.put(4, "night sky ");
		conHs.put(5, " sushank ");
		System.out.println(conHs);
		for(Map.Entry<Integer,String> e:conHs.entrySet()) {
			System.out.println(e.getKey()+" = "+e.getValue());
			
		}
		
	}

}
