package codevita;
import java.util.*;
public class DOLEOUTCADBURY {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int Q = sc.nextInt();
		int R = sc.nextInt();
		int S = sc.nextInt();
		long start = System.currentTimeMillis();
		List<Integer> cadburyDimensions = new ArrayList<Integer>();
		for(int i=P;i<=Q;i++)
		{
			for(int j=R;j<=S;j++)
			{
				cadburyDimensions.add(i);
				cadburyDimensions.add(j);
			}
		}
		List<Integer> sortedDimensions = new ArrayList<Integer>();
		for(int i=0;i<cadburyDimensions.size();i+=2)
		{
			sortedDimensions.add(Math.max(cadburyDimensions.get(i), cadburyDimensions.get(i+1)));
			sortedDimensions.add(Math.min(cadburyDimensions.get(i), cadburyDimensions.get(i+1)));
		}
		int studentsGiven = 0;
		
		for(int i=0;i<sortedDimensions.size();i+=2)
		{
			int temp = 0;
			if(sortedDimensions.get(i)%sortedDimensions.get(i+1) == 0)
			{
				studentsGiven += sortedDimensions.get(i) / sortedDimensions.get(i+1);
			}
			else {
				int max = Math.max(sortedDimensions.get(i), sortedDimensions.get(i+1));
				int min = Math.min(sortedDimensions.get(i), sortedDimensions.get(i+1));
				int a = max;
				int b = min;
				while(a!=1 || b!=1) {
					int a1 = Math.max(a, b);
					int b1 = Math.min(a, b);
					a=a1;b=b1;
					if(a == b)
					{
						temp++;
						a=0;
						b=0;
						break;
					}
					else {
						a=a-b;
						temp++;
					}
				}
				studentsGiven += (temp + (a*b));
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println(elapsedTime/1000 + " second");
		System.out.println(studentsGiven);
	}

}
