
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 31403. A + B - C
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		int cc = Integer.parseInt(c);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(b);
		
		System.out.println(aa + bb - cc);
		System.out.println(Integer.parseInt(sb.toString()) - cc);
	}
	
}
