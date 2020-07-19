package codevita;
import java.util.*;
public class DIGITPAIRS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		List<Integer> numbers = new ArrayList<Integer>();
		List<String> bitScoreMSBs = new ArrayList<String>();
		while(n-- > 0) {
			numbers.add(sc.nextInt());
		}
		for(int i=0;i<numbers.size();i++)
		{
			String num = numbers.get(i).toString();
			int d1 = Character.getNumericValue(num.charAt(0));
			int d2 = Character.getNumericValue(num.charAt(1));
			int d3 = Character.getNumericValue(num.charAt(2));
			int max = Math.max(Math.max(d1, d2), d3);
			int min = Math.min(Math.min(d1, d2), d3);
			String bitScore = Integer.toString((max*11) + (min*7));
			if(bitScore.length() == 3)
			{
				bitScore = (Character.toString(bitScore.charAt(1)) + Character.toString(bitScore.charAt(2)));
			}
			bitScoreMSBs.add(Character.toString(bitScore.charAt(0)));
		}
		//System.out.println("all bit score msb's" + bitScoreMSBs);
		List<String> oddBitScoreMSBs = new ArrayList<String>();
		List<String> evenBitScoreMSBs = new ArrayList<String>();
		for(int i=0;i<bitScoreMSBs.size();i+=2)
		{
			oddBitScoreMSBs.add(bitScoreMSBs.get(i));
		}
		for(int i=1;i<bitScoreMSBs.size();i+=2)
		{
			evenBitScoreMSBs.add(bitScoreMSBs.get(i));
		}
//		System.out.println("odd positions" + oddBitScoreMSBs);
//		System.out.println("even positions " + evenBitScoreMSBs);
		int count = 0;
		List<String> oddBitScoreMSBsUnique = new ArrayList<String>();
		List<String> evenBitScoreMSBsUnique = new ArrayList<String>();
		for(int i=0;i<oddBitScoreMSBs.size();i++)
		{
			if(!oddBitScoreMSBsUnique.contains(oddBitScoreMSBs.get(i)))
			{
				oddBitScoreMSBsUnique.add(oddBitScoreMSBs.get(i));
			}
		}
		for(int i=0;i<evenBitScoreMSBs.size();i++)
		{
			if(!evenBitScoreMSBsUnique.contains(evenBitScoreMSBs.get(i)))
			{
				evenBitScoreMSBsUnique.add(evenBitScoreMSBs.get(i));
			}
		}
//		System.out.println("odd position uniques" + oddBitScoreMSBsUnique);
//		System.out.println("even position uniques" + evenBitScoreMSBsUnique);
		Map<String,Integer> finalMap = new HashMap<String,Integer>();
		//initialize the map with all keys 0
		for(int i=0;i<oddBitScoreMSBsUnique.size();i++)
		{
			if(!finalMap.containsKey(oddBitScoreMSBsUnique.get(i)))
			{
				finalMap.put(oddBitScoreMSBsUnique.get(i), 0);
			}
		}
		for(int i=0;i<evenBitScoreMSBsUnique.size();i++)
		{
			if(!finalMap.containsKey(evenBitScoreMSBsUnique.get(i)))
			{
				finalMap.put(evenBitScoreMSBsUnique.get(i), 0);
			}
		}
//		System.out.println("Final Map initialized");
//		System.out.println(finalMap);
		for(Map.Entry<String, Integer> entry: finalMap.entrySet())
		{
			if(Collections.frequency(oddBitScoreMSBs, entry.getKey()) == 2 && entry.getValue() < 2)
			{
				finalMap.put(entry.getKey(), entry.getValue()+1);
			}
			else if(Collections.frequency(oddBitScoreMSBs, entry.getKey()) >= 3 && entry.getValue() < 1)
			{
				finalMap.put(entry.getKey(), entry.getValue()+2);
			}
		}
		for(Map.Entry<String, Integer> entry: finalMap.entrySet())
		{
			if(Collections.frequency(evenBitScoreMSBs, entry.getKey()) == 2 && entry.getValue() < 2)
			{
				finalMap.put(entry.getKey(), entry.getValue()+1);
			}
			else if(Collections.frequency(evenBitScoreMSBs, entry.getKey()) >= 3 && entry.getValue() < 1)
			{
				finalMap.put(entry.getKey(), entry.getValue()+2);
			}
		}
//		System.out.println("Finally final map");
//		System.out.println(finalMap);
		for(Map.Entry<String, Integer> entry: finalMap.entrySet())
		{
			count+= entry.getValue();
		}
		//System.out.println("Final count");
		System.out.println(count);
	}

}
