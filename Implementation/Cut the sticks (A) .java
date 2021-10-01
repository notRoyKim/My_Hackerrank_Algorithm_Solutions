import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here
        boolean flag = true;
        List result = new ArrayList();
        
        int min = 1000;
        
        for(int a : arr) {
            if(min > a) {
                min = a;
            }
        }
        
        while(flag) {
            
            int cnt = 0;
            int tmin = 1000;
            
            for(int i = 0; i < arr.size(); i++) {
                int a = arr.get(i);
                
                if(a != 0) {
                    a -= min;
                    arr.set(i,a);
                    cnt++;
                    if(tmin > a && a != 0) {
                        tmin = a;
                    }
                }
                
            }
            if(tmin == 1000) {
                flag = false;
            }
            
            result.add(cnt);
            min = tmin;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
