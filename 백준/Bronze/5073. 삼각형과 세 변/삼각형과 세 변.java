import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] strNums = br.readLine().split(" ");
            int[] nums = new int[3];
            nums[0] = Integer.parseInt(strNums[0]);
            nums[1] = Integer.parseInt(strNums[1]);
            nums[2] = Integer.parseInt(strNums[2]);
            Arrays.sort(nums);
            
            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                break;
            }
            
            if (nums[0] + nums[1] <= nums[2]) {
                sb.append("Invalid\n");
            }
            else if (nums[0] == nums[1] && nums[1] == nums[2]) {
                sb.append("Equilateral\n");
            }
            else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
                sb.append("Isosceles\n");
            }
            else {
                sb.append("Scalene\n");
            }
        }
        System.out.println(sb);
    }
}