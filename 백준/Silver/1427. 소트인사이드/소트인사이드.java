
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
		
		String[] strList = str.split("");
		int[] numList = new int[strList.length];
		
		for(int i = 0; i < strList.length; i++) {
			numList[i] = Integer.parseInt(strList[i]);
		}
		
		Arrays.sort(numList);
		
		for(int i = numList.length - 1; i >= 0; i--) {
			System.out.print(numList[i]);
		}
	}
}
