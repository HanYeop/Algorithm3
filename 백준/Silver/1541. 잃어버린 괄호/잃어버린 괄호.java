
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int result = 0;
		
		String[] strList = str.split("-");
		
		for(int i = 0; i < strList.length; i++) {
			if(i == 0) {
				result += solve(strList[i]);
				continue;
			}
			
			result -= solve(strList[i]);
		}
		
		System.out.println(result);
	}
	
	static int solve(String str) {
		int result = 0;
		
		String[] strList = str.split("\\+");
		
		for(int i = 0; i < strList.length; i++) {
			result += Integer.parseInt(strList[i]);
		}
		
		return result;
	}
}
