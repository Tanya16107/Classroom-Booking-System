import java.lang.*;
import java.io.*;
import java.util.*;
public class Search{
	public static void main(String[] args)
	{
		try{
			List<Course> L=new ArrayList<Course>();
			FileInputStream F=new FileInputStream("db_Courses.txt");
			ObjectInputStream O=new ObjectInputStream(F);
			L=(List<Course>)O.readObject();
			HashMap < String,List < Course > > M=new HashMap <String,List<Course>>();
			for(int j=0;j<L.size();j++)
			{
				String S1=L.get(j).getPostConditions();
				S1=S1.replaceAll(",","");
				List<String> S2=new ArrayList<String>(Arrays.asList(S1.split("\\s+")));
				for(int i=0;i<S2.size();i++)
				{
					if(M.containsKey(S2.get(i)))
					{
						List<Course> Temp=M.get(S2.get(i));
						Temp.add(L.get(j));
						M.put(S2.get(i),Temp);
					}
					else
					{
						List<Course> Temp=new ArrayList<Course>();
						Temp.add(L.get(j));
						M.put(S2.get(i),Temp);
					}
				}
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String Q1=br.readLine();
			HashSet<Course> LEL=new HashSet<Course>();
			List<String> Q2=new ArrayList<String>(Arrays.asList(Q1.split("\\s+")));
			for(int i=0;i<Q2.size();i++)
			{
				if(M.containsKey(Q2.get(i)))
				{
					List<Course> Temp=M.get(Q2.get(i));
					for(int j=0;j<Temp.size();j++)
						LEL.add(Temp.get(j));
				}
			}
			Iterator<Course> itr=LEL.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		}catch(Exception E){
			E.printStackTrace();
		}
	}
}