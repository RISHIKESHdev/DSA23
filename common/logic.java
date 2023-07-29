package common;

public class logic {
    public static int[] reverseIntFrom(int[] nums,int x){
        int y=nums.length-1;
        while(x<y){
            swapInt(nums,x,y);
            x++;
            y--;
        }
        return nums;
    }
    public static int[] swapInt(int[] nums,int x,int y){
        int temp=0;
        temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
        return nums;
    }
}
