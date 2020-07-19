package codevita;
import java.util.*;
public class SWAYAMBHAR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		//K9ei81g
		sc.nextLine();
		String bride = sc.nextLine();
		String groom = sc.nextLine();
		Queue<Character> brides = new LinkedList<Character>();
		Deque<Character> grooms = new LinkedList<Character>();
		for(int i=0;i<bride.length();i++)
		{
			brides.add(bride.charAt(i));
		}
		for(int i=0;i<groom.length();i++)
		{
			grooms.add(groom.charAt(i));
		}

		while(grooms.contains(brides.peek()))
		{
				if(brides.peek().equals(grooms.peek()))
				{
					brides.remove();
					grooms.removeFirst();
				}
				else {
					char c = grooms.peek();
					grooms.removeFirst();
					grooms.addLast(c);
				}
		}
		System.out.println(brides.size());
	}

}
