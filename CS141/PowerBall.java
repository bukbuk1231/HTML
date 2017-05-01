import java.util.Random;
public class PowerBall{
    public static void main(String[] args){
	int[] nums = new int[5];
	Random ran = new Random();
	int tmp = 0;
	for (int i = 0; i < 5; i++){
	    nums[i] = ran.nextInt(69) + 1;
	}
	int red = ran.nextInt(26) + 1;
	nums = sort(nums, nums.length - 1);
	System.out.println("Today's powerball numbers are: ");
	for (int k = 0; k < 5; k++){
	    System.out.print(nums[k] + " ");
	}
	System.out.println("Red: " + red);
    }

	public static int[] sort(int[] nums, int bottom){	   
	    int max = 0;
	    int tmp = 0;
	    if (bottom != 0) {
		max = findMax(nums, bottom, 0, 1);
		tmp = nums[bottom];
		nums[bottom] = nums[max];
		nums[max] = tmp;
		return sort(nums, bottom - 1);
		}
	    return nums;
	}
	public static int findMax(int[] nums, int bottom, int assumedMax, int current){
	    if (current <= bottom){
		if (nums[assumedMax] < nums[current])
		    return findMax(nums, bottom, current, current + 1);
		else
		    return findMax(nums, bottom, assumedMax, current + 1);
	    }
	    return assumedMax;
    }
}	